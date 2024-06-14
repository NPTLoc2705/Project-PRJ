<%-- 
    Document   : FileUpload
    Created on : Jun 14, 2024, 10:10:14 AM
    Author     : Tab135
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
        <div class="Uploader">
            <form method="POST" action="Upload" enctype="multipart/form-data">
                <input type ="file" name ="file"/>
                <input type ="text" name ="bookname" placeholder="Book name"/>
                <input type = "text" name = "author" placeholder = "author"/>
                <input type = "text" name = "description" placeholder = "description"/>
                <input type ="submit" value="Upload"/>
                
            </form>
        </div>
    </body>
</html>
