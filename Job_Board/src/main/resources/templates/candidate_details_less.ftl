<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Job Board</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="/img/favicon.png">
    <!-- Place favicon.ico in the root directory -->
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <!-- CSS here -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/css/magnific-popup.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/themify-icons.css">
    <link rel="stylesheet" href="/css/nice-select.css">
    <link rel="stylesheet" href="/css/flaticon.css">
    <link rel="stylesheet" href="/css/gijgo.css">
    <link rel="stylesheet" href="/css/animate.min.css">
    <link rel="stylesheet" href="/css/slicknav.css">

    <link rel="stylesheet" href="/css/style.css">
    <!-- <link rel="stylesheet" href="css/responsive.css"> -->
</head>

<body>
<!--[if lte IE 9]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade
    your browser</a> to improve your experience and security.</p>
<![endif]-->

<!-- header-start -->
<header>
    <div class="header-area ">
        <div id="sticky-header" class="main-header-area">
            <div class="container-fluid ">
                <div class="header_bottom_border">
                    <div class="row align-items-center">
                        <div class="col-xl-3 col-lg-2">
                            <div class="logo">
                                <a href="/index">
                                    <img src="/img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-7">
                            <div class="main-menu  d-none d-lg-block">
                                <nav>
                                    <ul id="navigation">
                                        <li><a href="/index">home</a></li>
                                        <li><a href="/jobs">Browse Job</a></li>
                                        <li><a href="#">pages <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="/candidate">Candidates </a></li>
                                                <li><a href="/elements">elements</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="#">blog <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="/blog">blog</a></li>
                                                <li><a href="/single_blog">single-blog</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="/contact">Contact</a></li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 d-none d-lg-block">
                            <div class="Appointment">
                                <div class="phone_num d-none d-xl-block">
                                    <a href="/my_profile">My profile</a>
                                </div>
                                <div class="d-none d-lg-block">
                                    <a class="boxed-btn3" href="/create_profile">Create profile</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-12">
                            <div class="mobile_menu d-block d-lg-none"></div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</header>
<!-- header-end -->

<!-- bradcam_area  -->
<#list candidates as candidate>
    <div class="bradcam_area bradcam_bg_1">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="bradcam_text">
                        <h3>${candidate.skill.name}</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--/ bradcam_area  -->

    <div class="job_details_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="job_details_header">
                        <div class="single_jobs white-bg d-flex justify-content-between">
                            <div class="jobs_left d-flex align-items-center">
                                <div class="thumb">
                                    <img src="${candidate.link_img}" width="50" height="50" alt="">
                                </div>
                                <div class="jobs_conetent">
                                    <a href="#"><h4>${candidate.firstName} ${candidate.lastName}</h4></a>
                                    <div class="links_locat d-flex align-items-center">
                                        <div class="location">
                                            <p> <i class="fa fa-map-marker"></i>${candidate.country.name}, ${candidate.city.name}</p>
                                        </div>
                                        <div class="location">
                                            <p> <i class="fa fa-clock-o"></i>Looking for job</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="jobs_right">
                                <div class="apply_now">
                                    <a class="heart_mark" href="#"> <i class="ti-heart"></i> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="descript_wrap white-bg">
                        <div class="single_wrap">
                            <h4>Employee description</h4>
                            <p>${candidate.description?substring(0, 50)}</p>
                        </div>
                        <div class="single_wrap">
                            <h4>Responsibility</h4>
                            <ul>
                                <li>The applicants should have experience in the following areas.
                                </li>
                                <li>Have sound knowledge of commercial activities.</li>
                                <li>Leadership, analytical, and problem-solving abilities.</li>
                                <li>Should have vast knowledge in IAS/ IFRS, Company Act, Income Tax, VAT.</li>
                            </ul>
                        </div>
                        <div class="single_wrap">
                            <h4>Qualifications</h4>
                            <ul>
                                <li>The applicants should have experience in the following areas.
                                </li>
                                <li>Have sound knowledge of commercial activities.</li>
                                <li>Leadership, analytical, and problem-solving abilities.</li>
                                <li>Should have vast knowledge in IAS/ IFRS, Company Act, Income Tax, VAT.</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="col-lg-4">
                    <div class="job_sumary">
                        <div class="summery_header">
                            <h3>Employee Summery</h3>
                        </div>
                        <div class="job_content">
                            <ul>
                                <li>Published on: <span>12 Nov, 2019</span></li>
                                <li>Skill: <span> ${candidate.skill.name}</span></li>
                                <li>Age: <span> ${candidate.age}</span></li>
                                <li>Country: <span> ${candidate.country.name}</span></li>
                                <li>City: <span> ${candidate.city.name}</span></li>
                                <li>Gender: <span> ${candidate.gender}</span></li>
                                <li>Education: <span> ${candidate.education.name}</span></li>
                                <li>Native language: <span> ${candidate.native_language.name}</span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="share_wrap d-flex">
                        <span>Share at:</span>
                        <ul>
                            <li><a href="#"> <i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"> <i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#"> <i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"> <i class="fa fa-envelope"></i></a></li>
                        </ul>
                    </div>
                    <div class="job_location_wrap">
                        <div class="job_lok_inner">
                            <div id="map" style="height: 200px;"></div>
                            <script>
                                function initMap() {
                                    var uluru = {lat: -25.363, lng: 131.044};
                                    var grayStyles = [
                                        {
                                            featureType: "all",
                                            stylers: [
                                                {saturation: -90},
                                                {lightness: 50}
                                            ]
                                        },
                                        {elementType: 'labels.text.fill', stylers: [{color: '#ccdee9'}]}
                                    ];
                                    var map = new google.maps.Map(document.getElementById('map'), {
                                        center: {lat: -31.197, lng: 150.744},
                                        zoom: 9,
                                        styles: grayStyles,
                                        scrollwheel: false
                                    });
                                }

                            </script>
                            <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDpfS1oRGreGSBU5HHjMmQ3o5NLw7VdJ6I&callback=initMap"></script>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#list>

<!-- footer start -->
<footer class="footer">
    <div class="footer_top">
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1s" data-wow-delay=".3s">
                        <div class="footer_logo">
                            <a href="#">
                                <img src="/img/logo.png" alt="">
                            </a>
                        </div>
                        <p>
                            finloan@support.com <br>
                            +10 873 672 6782 <br>
                            600/D, Green road, NewYork
                        </p>
                        <div class="socail_links">
                            <ul>
                                <li>
                                    <a href="#">
                                        <i class="ti-facebook"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-google-plus"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-instagram"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
                <div class="col-xl-2 col-md-6 col-lg-2">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1.1s" data-wow-delay=".4s">
                        <h3 class="footer_title">
                            Company
                        </h3>
                        <ul>
                            <li><a href="#">About </a></li>
                            <li><a href="#"> Pricing</a></li>
                            <li><a href="#">Carrier Tips</a></li>
                            <li><a href="#">FAQ</a></li>
                        </ul>

                    </div>
                </div>
                <div class="col-xl-3 col-md-6 col-lg-3">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1.2s" data-wow-delay=".5s">
                        <h3 class="footer_title">
                            Category
                        </h3>
                        <ul>
                            <li><a href="#">Design & Art</a></li>
                            <li><a href="#">Engineering</a></li>
                            <li><a href="#">Sales & Marketing</a></li>
                            <li><a href="#">Finance</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-xl-4 col-md-6 col-lg-4">
                    <div class="footer_widget wow fadeInUp" data-wow-duration="1.3s" data-wow-delay=".6s">
                        <h3 class="footer_title">
                            Subscribe
                        </h3>
                        <form action="/subscribe" class="newsletter_form" id="form">
                            <input id="email" name="email" type="text" placeholder="Enter your mail">
                            <button type="submit" onclick="return validateForm1()">Subscribe</button>
                        </form>

                        <script>
                            function validateForm1() {
                                let email = document.getElementById('email');
                                let error = '';
                                let email_regexp = /[0-9a-zа-я_A-ZА-Я]+@[0-9a-zа-я_A-ZА-Я^.]+\.[a-zа-яА-ЯA-Z]{2,4}/i;
                                if (!email_regexp.test(email.value)) {
                                    error += 'Email is entered incorrectly! \n';
                                }
                                if (error !== '') {
                                    swal("Oops", error, "error");
                                    return false;
                                } else {
                                    let form = document.getElementById("form");
                                    form.submit();
                                }
                            }
                        </script>
                        <p class="newsletter_text">Esteem spirit temper too say adieus who direct esteem esteems
                            luckily.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copy-right_text wow fadeInUp" data-wow-duration="1.4s" data-wow-delay=".3s">
        <div class="container">
            <div class="footer_border"></div>
            <div class="row">
                <div class="col-xl-12">
                </div>
            </div>
        </div>
    </div>
</footer>
<!--/ footer end  -->

<!-- link that opens popup -->
<!-- JS here -->
<script src="/js/vendor/modernizr-3.5.0.min.js"></script>
<script src="/js/vendor/jquery-1.12.4.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/owl.carousel.min.js"></script>
<script src="/js/isotope.pkgd.min.js"></script>
<script src="/js/ajax-form.js"></script>
<script src="/js/waypoints.min.js"></script>
<script src="/js/jquery.counterup.min.js"></script>
<script src="/js/imagesloaded.pkgd.min.js"></script>
<script src="/js/scrollIt.js"></script>
<script src="/js/jquery.scrollUp.min.js"></script>
<script src="/js/wow.min.js"></script>
<script src="/js/nice-select.min.js"></script>
<script src="/js/jquery.slicknav.min.js"></script>
<script src="/js/jquery.magnific-popup.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/gijgo.min.js"></script>


<!--contact js-->
<script src="/js/contact.js"></script>
<script src="/js/jquery.ajaxchimp.min.js"></script>
<script src="/js/jquery.form.js"></script>
<script src="/js/jquery.validate.min.js"></script>
<script src="/js/mail-script.js"></script>


<script src="/js/main.js"></script>
</body>

</html>