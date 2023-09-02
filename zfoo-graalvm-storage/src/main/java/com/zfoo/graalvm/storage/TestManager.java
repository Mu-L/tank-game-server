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

package com.zfoo.graalvm.storage;

import com.zfoo.graalvm.storage.resource.TestResource;
import com.zfoo.storage.anno.StorageAutowired;
import com.zfoo.storage.model.IStorage;
import org.springframework.stereotype.Component;

/**
 * @author godotg
 * @version 3.0
 */
@Component
public class TestManager {

    @StorageAutowired
    public IStorage<Integer, TestResource> testResources;

}
