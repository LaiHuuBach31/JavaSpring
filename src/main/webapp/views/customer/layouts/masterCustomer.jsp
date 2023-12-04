<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Piza Store</title>

<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/foody.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Gochi+Hand|Montserrat:300,400,400i,500,500i,600,700,800,900|PT+Serif:400,400i,700,700i"
	rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" >

</head>

<body>

	<div class="">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/foody.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/DevSolutionSkill.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.themepunch.tools.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/jquery.themepunch.revolution.min.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/script.js"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/https://maps.googleapis.com/maps/api/js?key=AIzaSyCiqrIen8rWQrvJsu-7f4rOta0fmI5r2SI&amp;sensor=false&amp;language=en"></script>
	<script
		src="${pageContext.servletContext.contextPath}/resources/js/gmap3.min.js"></script>


	<script>
		var tpj=jQuery;
		var revapi202;
		tpj(document).ready(function() {
			if (tpj("#rev_slider_202_1").revolution == undefined) {
				revslider_showDoubleJqueryError("#rev_slider_202_1");
			} else {
				revapi202 = tpj("#rev_slider_202_1").show().revolution({
					sliderType: "standard",
					jsFileLocation: "js/",
					sliderLayout: "fullscreen",
					dottedOverlay: "none",
					delay: 90000,
					navigation: {
						keyboardNavigation: "off",
						keyboard_direction: "horizontal",
						mouseScrollNavigation: "off",
						onHoverStop: "off",
						touch: {
							touchenabled: "on",
							swipe_threshold: 75,
							swipe_min_touches: 50,
							swipe_direction: "horizontal",
							drag_block_vertical: false
						},
						bullets: {
							enable: false
						},
                        arrows: {

							enable: true,
							style: 'metis',
							tmp: '',
							rtl: false,
							hide_onleave: false,
							hide_onmobile: true,
							hide_under: 0,
							hide_over: 9999,
							hide_delay: 200,
							hide_delay_mobile: 1200,

							left: {
								container: 'slider',
								h_align: 'right',
								v_align: 'bottom',
								h_offset: 100,
								v_offset: 40
							},

							right: {
								container: 'slider',
								h_align: 'right',
								v_align: 'bottom',
								h_offset: 40,
								v_offset: 40
							}

						}
					},
					responsiveLevels: [1230, 1024, 778, 480],
					visibilityLevels: [1230, 1024, 778, 480],
					gridwidth: [1230, 1024, 778, 480],
					gridheight: [700, 700, 600, 600],
					lazyType: "none",
					parallax: {
						type: "scroll",
						origo: "slidercenter",
						speed: 1000,
						levels: [5, 10, 15, 20, 25, 30, 35, 40, 45, 46, 47, 48, 49, 50, 100, 55],
						type: "scroll",
					},
					shadow: 0,
					spinner: "off",
					stopLoop: "off",
					stopAfterLoops: -1,
					stopAtSlide: -1,
					shuffle: "off",
					autoHeight: "off",
					fullScreenAutoWidth: "off",
					fullScreenAlignForce: "off",
					fullScreenOffsetContainer: "",
					fullScreenOffset: "0px",
					disableProgressBar: "on",
					hideThumbsOnMobile: "off",
					hideSliderAtLimit: 0,
					hideCaptionAtLimit: 0,
					hideAllCaptionAtLilmit: 0,
					debugMode: false,
					fallbacks: {
						simplifyAll: "off",
						nextSlideOnWindowFocus: "off",
						disableFocusListener: false,
					}
				});
			}
		}); /*ready*/
	</script>	


</body>

</html>