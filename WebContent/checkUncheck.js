function checkRefresh(value)
{
    document.form1.submit();
}    

/*
 * 1 -> I dont care (uncheck all)
 * 2 -> I care (uncheck i dont care)
 * */
function uncheck(check)
{
    var c1 = document.getElementById("c1");
    var c2 = document.getElementById("c2");
    var c3 = document.getElementById("c3");
    var c4 = document.getElementById("c4");
    var c5 = document.getElementById("c5");
    var c6 = document.getElementById("c6");
    var c7 = document.getElementById("c7");
    var c8 = document.getElementById("c8");

    var s1 = document.getElementById("s1");
    var s2 = document.getElementById("s2");
    var s3 = document.getElementById("s3");
    var s4 = document.getElementById("s4");
    var s5 = document.getElementById("s5");
    var s6 = document.getElementById("s6");
    var s7 = document.getElementById("s7");
    var s8 = document.getElementById("s8");
    
    if (c8.checked == true && check == 1)
    {
        c1.checked = false;
        c2.checked = false;
        c3.checked = false;
        c4.checked = false;
        c5.checked = false;
        c6.checked = false;
        c7.checked = false;
        checkRefresh();    
    }
    
    if (check == 2)
    {
    	c8.checked = false;
    	checkRefresh();
    }

    if (s8.checked == true && check == 3)
    {
        s1.checked = false;
        s2.checked = false;
        s3.checked = false;
        s4.checked = false;
        s5.checked = false;
        s6.checked = false;
        s7.checked = false;
        checkRefresh();    
    }
    
    if (check == 4)
    {
    	s8.checked = false;
    	checkRefresh();
    }
}