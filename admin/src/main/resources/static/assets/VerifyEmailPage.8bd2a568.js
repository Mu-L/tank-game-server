import{d as v,r as e,g as f,ak as m,i as _,w as i,s as p,o as g,b as h,e as x,t as k,k as o,p as y,m as c,_ as T}from"./index.78d81d6b.js";const b=c("h1",{class:"text-h5 font-weight-bold"},"Please verify the email",-1),V=c("div",{class:"mb-5 text-grey text-caption"}," Please check your email for the link to verify the email. ",-1),E=v({__name:"VerifyEmailPage",setup(I){const d=e(!1),s=e(!0),n=e(0),t=e(""),a=e(5),l=e(),r=()=>{s.value=!0,n.value++,a.value=5*n.value,l.value=setInterval(()=>{a.value===0?(clearInterval(l.value),t.value="",s.value=!1):(t.value=`( ${a.value} )`,a.value--)},1e3)},u=()=>{r()};return f(()=>{r()}),m(()=>{clearInterval(l.value)}),(w,B)=>(g(),_(p,{class:"pa-5"},{default:i(()=>[b,V,h(y,{class:"text-capitalize",block:"",color:"primary",size:"x-large",loading:o(d),disabled:o(s),onClick:u},{default:i(()=>[x("Re-send email"+k(o(t)),1)]),_:1},8,["loading","disabled"])]),_:1}))}}),M=T(E,[["__file","D:/Project/tank-game-server-ts/admin-vue3-ts/src/views/auth/VerifyEmailPage.vue"]]);export{M as default};