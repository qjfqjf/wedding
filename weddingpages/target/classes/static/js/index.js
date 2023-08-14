//window.onload=showBigAd;
window.onload=showBigAd;
//显式大的广告图函数
function  showBigAd(){
    $("#topad").animate({height:'toggle'},2000,function (){$("#topsmallad").animate({height: 'toggle'},1000)});
}