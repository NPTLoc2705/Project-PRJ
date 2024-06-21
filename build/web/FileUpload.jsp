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
        <<div class="tm-header">
            <div class="container-fluid">
                <div class="tm-header-inner">
                    <div class="tm-header-logo">
                        <a href="#" class="navbar-brand tm-site-name"
                           ><img src="img/hinh.png" alt=""
                              /></a>
                    </div>

                    <!-- navbar -->
                    <nav class="navbar tm-main-nav">
                        <button
                            class="navbar-toggler hidden-md-up"
                            type="button"
                            data-toggle="collapse"
                            data-target="#tmNavbar"
                            >
                            &#9776;
                        </button>

                        <div class="collapse navbar-toggleable-sm" id="tmNavbar">
                            <ul class="nav navbar-nav">
                                <div class ="search-box">
                                    <input class="search-box-input" type="text">
                                    <button class="search-box-bth" type="submit"><ion-icon name="search-outline"></ion-icon></button>

                                </div>
                                <li class="nav-item active">
                                    <a href="index.html" class="nav-link">Home</a>
                                </li>
                                <li class="nav-item">
                                    <a href="about.html" class="nav-link">About</a>
                                </li>
                                <li class="nav-item">
                                    <a href="Login.jsp" class="nav-link">Sign up</a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="upload-box">
                <div class="upload-icon">
                    <i class="fas fa-upload"></i>
                </div>
                <h2>Upload your book</h2>
                <form>
                    <div class="input-group">
                        <label for="file-upload" class="file-label">Choose file</label>
                        <input type="file" id="file-upload" class="file-input">
                        <span>No file chosen</span>
                    </div>
                    <div class="input-group">
                        <label for="cover-upload" class="file-label">Choose file</label>
                        <input type="file" id="cover-upload" class="file-input">
                        <input type="text" placeholder="Book cover" class="text-input">
                    </div>
                    <div class="text-fields">
                        <input type="text" placeholder="Author" class="text-input">
                        <input type="text" placeholder="Book name" class="text-input">
                    </div>
                    <div class="description-field">
                        <textarea placeholder="Description" class="textarea-input"></textarea>
                    </div>
                    <button type="submit" class="upload-button">Upload</button>
                </form>
            </div>
        </div>
    </body>
</html>
