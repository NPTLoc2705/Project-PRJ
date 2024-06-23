<%-- 
    Document   : FileUpload
    Created on : Jun 14, 2024, 10:10:14 AM
    Author     : Tab135
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>


        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"
            />

        <link rel="stylesheet" href="CSS/bootstrap.min.css" />
        <link rel="stylesheet" href="CSS/templatemo-style.css" />
        <link rel="stylesheet" href="CSS/Upload.css"/>
        <title>File Upload</title>
    </head>
    <body>
        <%@ include file="/nav.jsp" %>
        <div class="container">
            <div class="upload-box">
                <div class="upload-icon">
                    <i class="fas fa-upload"></i>
                </div>
                <h2>Upload your book</h2>
                <form action="Upload" method = "POST" enctype="multipart/form-data">
                    <div class="input-group">
                        <label for="file-upload" class="file-label">Choose file</label>
                        <input type="file" id="file-upload" class="file-input" name ="file">
                        <span id="file-chosen">No file chosen</span>
                    </div>
                    
                    <div class="input-group">
                        <label for="cover-upload" class="file-label">Choose file</label>
                        <input type="file" id="cover-upload" class="file-input" name="cover-image">
                        <span id="file-chosen2">No file chosen</span>
                    </div>
<div class="input-group">
    <label for="genres">Choose a book genre(s):</label><br>
    <input type="checkbox" id="horror" name="genres" value="Horror">
    <label for="horror">Horror</label><br>
    <input type="checkbox" id="romance" name="genres" value="Romance">
    <label for="romance">Romance</label><br>
    <input type="checkbox" id="dark-fantasy" name="genres" value="Dark-Fantasy">
    <label for="dark-fantasy">Dark Fantasy</label><br>
</div>
                    <div class="text-fields">
                        <input type="text" placeholder="Author" class="text-input" name = "author">
                        <input type="text" placeholder="Book name" class="text-input" name = "bookname">
                    </div>
                    <div class="description-field">
                        <textarea placeholder="Description" class="textarea-input" name = "description"></textarea>
                    </div>
                    <button type="submit" class="upload-button">Upload</button>
                </form>
            </div>
        </div>
    </body>
    
    <script>
        const actualBtn = document.getElementById('file-upload');
        const BtnImage = document.getElementById('cover-upload');
const fileChosen = document.getElementById('file-chosen');
const fileChosen2 = document.getElementById('file-chosen2');
actualBtn.addEventListener('change', function(){
  fileChosen.textContent = this.files[0].name;
});
BtnImage.addEventListener('change', function(){
  fileChosen2.textContent = this.files[0].name;
});
        
    </script>
</html>
