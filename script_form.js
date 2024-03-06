function check()
{
    let flag=true;

    //checking name
    let name=document.getElementById("name").value;
    if(!(/^[a-z]+$/.test(name)) && name!==''){
        alert("Name can only have alphabets");
        flag=false;
    }

    //e-mail
    let email=document.getElementById("email").value;
    var pattern = /[a-z0-9]@[a-z0-9].[a-z]{2,3}(.[a-z]{2}?)/;
    if(!pattern.test(email) && email!==''){
        alert("Enter valid email address. Only small letters & special characters with email domain");
        flag=false;
    }

    //gender
    let m = document.getElementById("m").checked;
    let f = document.getElementById("f").checked;
    if(!m && !f){
        alert("Kindly enter gender!");
        flag=false;
    }

    //password
    var pass1=document.getElementById("p1").value;
    var pass2=document.getElementById("p2").value;
    if(pass1!=(pass2)  && pass1!=''){
        alert("Given passwords mismatch with each other!");
        document.getElementById("p1").innerHTML='';
        document.getElementById("p2").innerHTML='';
        flag=false;
    }
    if(pass1.length<8){
        alert("Minimum length of password is 8");
        flag=false;
    }

    //mobile no
    var num=document.getElementById("tel").value;
    if(!(/[6-9]{1}[0-9]{9}/.test(num)) && num!==''){
        alert("Invalid mobile number provided. Kindly Recheck");
        document.getElementById("tel").innerHTML='';
        flag=false;
    }

    //address
    var add=document.getElementById("address").value;
    pattern = "^[a-zA-Z0-9\s,.\/]+$";
    if(!(/^[a-zA-Z0-9\s.,\'\/]+$/.test(add)) && add!==''){
        alert("Kindly enter your d/no, street & city details<br>Only alpahabets,space, ',', '-', '/' are allowed");
        document.getElementById("address").innerHTML='';
        flag=false;
    }

    //location
    var loc = document.getElementById("location");
    f=true;
    for(i=0;i<loc.length;i++){
        if(l.checked)
            f=false;
    }
    if(f){
        alert("Select your location");
        flag=false;
    }

    if(flag){
        alert("success")
        window.location.href="success.html";
    } 
}
