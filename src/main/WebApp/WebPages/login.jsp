<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>User Login</title>
<body style="background-color:cyan">

    
    <div class=" text-center " style=" color: blue; ">
        <h1 style="font-family: 'Times New Roman', Times, serif;">LOGIN</h1>
    </div>
    
    <div class=" col-sm-4 col-sm-offset-4 container" style="padding-top: 150px;">
        <form action="login" method="POST" class=" form-horizontal justify-content-center" style="background-color: transparent; border-radius: 25px;">
            <div class="form-group" >
                <label class="control-label col-sm-2" for="email">Username</label>
                <div class="col-sm-10">
                     <input type="email" name="email" class="form-control" id="email" placeholder="Input Email">
                </div>
            </div>
            <div class="form-group" ><label for="pwd" class="control-label col-sm-2">Password</label>
                <div class="col-sm-10"><input type="password" name="pwd" class="form-control" id="pwd" placeholder="Enter Password"></div>
            </div>
                <div class=" from-group col-sm-offset-2 col-sm-10" style="margin-bottom: 20px; " >
                    <a href="" style="color:blue;">Forgot Your Password?</a>
                </div>
            <div class="form-group">  
                <div class="col-sm-offset-2 col-sm-10 " > <button type="submit" class="btn btn-primary">Submit</button> </div>  
            </div> 
        </form>
    </div>
    
</body>
</html>