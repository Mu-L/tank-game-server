/*
 * Copyright (C) 2020 The zfoo Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */

package com.zfoo.protocol.serializer.enhance;

import com.zfoo.protocol.generate.GenerateProtocolFile;
import com.zfoo.protocol.registration.EnhanceUtils;
import com.zfoo.protocol.registration.field.IFieldRegistration;
import com.zfoo.protocol.registration.field.SetField;
import com.zfoo.protocol.serializer.CodeLanguage;
import com.zfoo.protocol.serializer.CutDownSetSerializer;
import com.zfoo.protocol.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author godotg
 */
public class EnhanceSetSerializer implements IEnhanceSerializer {

    @Override
    public void writeObject(StringBuilder builder, String objectStr, Field field, IFieldRegistration fieldRegistration) {
        if (CutDownSetSerializer.getInstance().writeObject(builder, objectStr, field, fieldRegistration, CodeLanguage.Enhance)) {
            return;
        }

        var setField = (SetField) fieldRegistration;
        var set = "set" + GenerateProtocolFile.localVariableId++;
        builder.append(StringUtils.format("Set {} = (Set){};", set, objectStr));

        builder.append(StringUtils.format("{}.writeInt($1, CollectionUtils.size({}));", EnhanceUtils.byteBufUtils, set));

        var iterator = "iterator" + GenerateProtocolFile.localVariableId++;
        builder.append(StringUtils.format("Iterator {} = CollectionUtils.iterator({});", iterator, set));
        builder.append(StringUtils.format("while({}.hasNext()) {", iterator));

        var element = "element" + GenerateProtocolFile.localVariableId++;
        builder.append(StringUtils.format("Object {}={}.next();", element, iterator));
        EnhanceUtils.enhanceSerializer(setField.getSetElementRegistration().serializer())
                .writeObject(builder, element, field, setField.getSetElementRegistration());
        builder.append("}");

    }

    @Override
    public String readObject(StringBuilder builder, Field field, IFieldRegistration fieldRegistration) {
        var cutDown = CutDownSetSerializer.getInstance().readObject(builder, field, fieldRegistration, CodeLanguage.Enhance);
        if (cutDown != null) {
            return cutDown;
        }

        var setField = (SetField) fieldRegistration;
        var set = "set" + GenerateProtocolFile.localVariableId++;

        var size = "size" + GenerateProtocolFile.localVariableId++;
        builder.append(StringUtils.format("int {} = {}.readInt($1);", size, EnhanceUtils.byteBufUtils));
        builder.append(StringUtils.format("Set {} = CollectionUtils.newSet({});", set, size));

        var i = "i" + GenerateProtocolFile.localVariableId++;
        builder.append(StringUtils.format("for(int {}=0; {}<{}; {}++){", i, i, size, i));

        var readObject = EnhanceUtils.enhanceSerializer(setField.getSetElementRegistration().serializer()).readObject(builder, field, setField.getSetElementRegistration());
        builder.append(StringUtils.format("{}.add({});}", set, readObject));
        return set;
    }

    @Override
    public String defaultValue(StringBuilder builder, Field field, IFieldRegistration fieldRegistration) {
        var setField = (SetField) fieldRegistration;
        var set = "set" + GenerateProtocolFile.localVariableId++;
        builder.append(StringUtils.format("Set {} = CollectionUtils.newSet(0);", set));
        return set;
    }

}
