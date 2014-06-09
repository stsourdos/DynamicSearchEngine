var imageCount = 3;  //how many images in total?
var changeSpeed = 3;  //how many seconds between fades?
var fadeSpeed = 0.5; //how many seconds should the fade take?
var fps = 25;  //animation frames per second

//BANNER FUNCTIONS:
var topImgID;
var changeInterval;

function $(id){ //just a shortcut function:
 return(document.getElementById(id));
}

function changeOpac(obj, opacity) {//change the opacity for different browsers:
 obj = obj.style; 
 obj.opacity = (opacity / 100);
 obj.MozOpacity = (opacity / 100);
 obj.KhtmlOpacity = (opacity / 100);
 obj.filter = "alpha(opacity=" + opacity + ")";
}

function changeImage(){
 var nextImgID = ( topImgID+1 <= imageCount ? topImgID+1 : 1 ); //get id number of next image in list
 var nextImg = $('banner'+nextImgID);
 var lastImg = $('banner'+topImgID);
 var opac = 0;
 changeOpac( nextImg, opac); //make next image invisible, then bring it to the top:
 lastImg.style.zIndex = 2;
 nextImg.style.zIndex = 3;

 var fadeInterval = setInterval(function(){ //run fade on interval:
  if(opac < 100){//continue fade:
   opac += Math.ceil(100/(fadeSpeed*fps));
   changeOpac(nextImg, opac);
  }else{//end fade:
   lastImg.style.zIndex = 1;
   clearInterval(fadeInterval);
  }
 }, 1000/fps);

 topImgID = nextImgID; //prepare next fade
}

function startBanner(firstImageID){
 topImgID = (firstImageID==undefined ? 1+Math.floor(Math.random()*(imageCount)) : firstImageID);
 $('banner'+topImgID).style.zIndex = 2;
 changeInterval = setInterval(changeImage, changeSpeed*1000);
}