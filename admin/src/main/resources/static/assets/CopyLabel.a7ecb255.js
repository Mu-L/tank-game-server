import{d as y,al as V,r as l,ae as k,o as g,a as B,b as p,w as o,p as T,e as d,t as c,k as t,a4 as L,am as w,m,U as N,an as S,ao as D,F,_ as P}from"./index.78d81d6b.js";const R=y({__name:"CopyLabel",props:{text:{type:String,default:""}},setup(f){const _=f,{copy:v}=V(),n=l("Copy"),a=l(!1),C=l("1000"),b="Copied to clipboard!",r=l(!1),{text:u}=k(_),x=i=>{v(i),r.value=!0,a.value=!0,n.value="Copied!",setTimeout(()=>{r.value=!1,n.value="Copy!"},1e3)};return(i,e)=>(g(),B(F,null,[p(w,{modelValue:t(a),"onUpdate:modelValue":e[1]||(e[1]=s=>L(a)?a.value=s:null),timeout:t(C)},{actions:o(()=>[p(T,{color:"blue",variant:"text",onClick:e[0]||(e[0]=s=>a.value=!1)},{default:o(()=>[d(" Close ")]),_:1})]),default:o(()=>[d(c(b)+" ")]),_:1},8,["modelValue","timeout"]),p(D,{location:"bottom"},{activator:o(({props:s})=>[m("span",N({class:[{heartBeat:t(r)===!0},"text"]},s,{onClick:e[2]||(e[2]=S(U=>x(t(u)),["stop","prevent"]))}),c(t(u)),17)]),default:o(()=>[m("span",null,c(t(n)),1)]),_:1})],64))}});const j=P(R,[["__scopeId","data-v-bc262fc9"],["__file","D:/Project/tank-game-server-ts/admin-vue3-ts/src/components/common/CopyLabel.vue"]]);export{j as C};