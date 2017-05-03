<!-- Created by Dipanjan Karmakar -->
<!DOCTYPE HTML>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:importAttribute name="stylesheets" />
<tiles:importAttribute name="javascripts" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="http://www.cs.iastate.edu/sites/all/themes/suitcase/images/favicon.ico"/>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<style type="text/css">
body {
	/* background-image:
		url('${pageContext.request.contextPath}/images/background.png'); */
	
}
</style>
<c:forEach var="css" items="${stylesheets}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
</c:forEach>
<!-- scripts-->
<c:forEach var="script" items="${javascripts}">
	<script type="text/javascript" src="<c:url value="${script}"/>"></script>
</c:forEach>
</head>

<body>
	<div class="skip">
		<a accesskey="2" href="#container">Skip Navigation</a>
	</div>
	<div class="hwrapper" id="header">
		<div id="top-strip">
			<div class="grids-24">
				<div class="grid-8">
					<ul class="left">
						<li><a href="http://cymail.iastate.edu/">CyMail</a></li>
						<li><a href="http://exchange.iastate.edu/">Outlook</a></li>
						<li><a href="http://webct.its.iastate.edu/">WebCT</a></li>
						<li><a href="http://bb.its.iastate.edu/">Blackboard</a></li>
						<li class="last"><a href="http://accessplus.iastate.edu/">AccessPlus</a></li>
					</ul>
				</div>
				<div class="grid-16">
					<ul class="right">
						<li class="idx"><a href="http://www.iastate.edu/index/A/">A</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/B/">B</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/C/">C</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/D/">D</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/E/">E</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/F/">F</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/G/">G</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/H/">H</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/I/">I</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/J/">J</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/K/">K</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/L/">L</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/M/">M</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/N/">N</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/O/">O</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/P/">P</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/Q/">Q</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/R/">R</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/S/">S</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/T/">T</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/U/">U</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/V/">V</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/W/">W</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/X/">X</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/Y/">Y</a></li>
						<li class="idx"><a href="http://www.iastate.edu/index/Z/">Z</a></li>
						<li class="border first"><a href="http://info.iastate.edu/">Directory</a></li>
						<li class="border"><a href="http://www.fpm.iastate.edu/maps/">Maps</a></li>
						<li class="border last"><a
							href="http://www.iastate.edu/contact/">Contact Us</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="ribbon">
			<div class="grids-24">
				<div class="grid-16">
					<h1 class="nameplate">
						<a accesskey="1" href="http://www.iastate.edu/"> <img
							alt="Iowa State University" src="images/sprite.png" />
						</a>
					</h1>
				</div>
				<div class="grid-8">
					<form action="http://google.iastate.edu/search" method="GET">
						<input name="output" type="hidden" value="xml_no_dtd" /> <input
							name="client" type="hidden" value="default_frontend" /> <input
							name="sitesearch" type="hidden" value="" /> <input
							name="proxystylesheet" type="hidden" value="default_frontend" />
						<input accesskey="s" name="q" placeholder="Search" tabindex="1"
							type="text" /> <input name="btnG" title="Search" type="submit"
							value="" />
					</form>
				</div>
			</div>
			<div class="grids-24">
				<div class="grid-12">
					<h2 class="site-title">
						<a href="http://www.las.iastate.edu/" target="blank"">College
							of Liberal Arts & Sciences <br>Department of Computer
							Science
						</a>
					</h2>
					<font size="-2" color="#FFCC00"><em><b>ALL SCIENCE
								IS COMPUTER SCIENCE</b></font></em>
				</div>
				<div class="grid-12"></div>

			</div>

		</div>
		<div id="menubar">
			<div class="grids-24">
				<ul class="navigation ">

					<li class="first"><a href="/">CS Department</a>

						<ul>
							<li class=""><a href="/department/people/faculty.php">Faculty
									Directory</a></li>
							<li class=""><a href="/department/people/staff.php">Staff
									Directory</a></li>
							<li class=""><a href="/department/people/students.php">Postdoc/Graduate
									Student Directory</a></li>
							<li class=""><a href="/department/lectures.php">Computer
									Science Colloquia/Distinguished Lecture Series</a></li>
							<li class=""><a href="/department/rsdl.php">Robert
									Stewart Distinguished Lecture</a></li>
							<li class=""><a href="/department/mission.php">Department
									Mission</a></li>
							<li class=""><a href="/department/history.php">Department
									History</a></li>
							<li class=""><a href="/department/advisoryboard.php">Advisory
									Board</a></li>
							<li class="last"><a href="http://support.cs.iastate.edu/">Systems
									Support Group</a></li>
						</ul></li>



					<li class=""><a href=""> Research</a>

						<ul>
							<li class=""><a href="../research/researchlabs.php">CS
									Research Labs</a></li>
							<li class=""><a href="/research/interdisclabs.php">Interdisciplinary
									Labs & Groups</a></li>
							<li class=""><a
								href="http://www.vpresearch.iastate.edu/isuresearch/">Grants</a></li>
							<li class=""><a href="http://archives.cs.iastate.edu/">Technical
									Reports</a></li>
							<li class="last"><a href="../../research/colloquia.php">Research
									Colloquia</a></li>
							<li class="">
						</ul></li>
					<li class=""><a href=""> Undergraduate</a>
						<ul>
							<li class="first"><a
								href="/undergraduate/prospectiveugrad.php">For Prospective
									Students</a></li>
							<li class=""><a href="/undergraduate/csugrad.php">BS in
									Computer Science</a></li>
							<li class=""><a href="/undergraduate/abet.php">CS ABET
									Accreditation</a></li>
							<li class=""><a href="http://www.se.iastate.edu/"
								target="_blank">BS in Software Engineering</a></li>
							<li class=""><a href="http://www.las.iastate.edu/bcbio/"
								target="_blank">BS in Computational Biology</a></li>
							<li class=""><a href="/undergraduate/bs_ms.php">Concurrent
									BS/MS Program</a>
							<li class=""><a href="/undergraduate/csminor.php">Computer
									Science Minor</a>
							<li class=""><a href="/undergraduate/nonmajor.php">Computing
									for Non-majors</a></li>
							<li class="">
							<li class=""></li>
							<li class=""></li>
							<li class="last"><a href="/undergraduate/studentgroups.php">Undergraduate
									Student Groups</a></li>
						</ul></li>
					<li class=""><a href=""> Graduate</a>
						<ul>
							<li class="first"><a href="/graduate/prospectivegrad.php">For
									Prospective Students</a></li>
							<li class=""><a href="/graduate/cs_ms.php/">MS in
									Computer Science</a></li>
							<li class=""><a href="/graduate/cs_phd.php">PhD in
									Computer Science</a></li>
							<li class=""><a href="/graduate/gradinterdisc.php">Interdisciplinary
									Graduate Programs</a></li>
							<li class="last"><a href="http://www.cs.iastate.edu/~gac/">Graduate
									Advisory Committee</a></li>
							<li class=""><a href="/graduate/cs_ms.php/">TA
									Application</a></li>
						</ul></li>
					<li class="last"><a href="">Outreach</a>
						<ul>
							<li class="first"><a href="/outreach/ctc.php">Computational
									Thinking</a></li>
							<li class="">
							<li class="last"><a href=""></a></li>
						</ul></li>


					<li class=""><a href=""> Internal Site</a>
						<ul>
							<li class="first"><a
								href="https://www.cs.iastate.edu/internal/">Intranet</a></li>
							<li class=""><a href="https://reservation.cs.iastate.edu/">Reserve
									a Conference Room</a></li>
						</ul></li>
				</ul>

				<div class="clear"></div>
				</a>
			</div>
		</div>
	</div>



	<div id="container">

		<div class="grids-24">

			<div class="grid-24" id="content" style="margin: 0;">


				<!-- end of common header part  -->
				<!-- the content of this page -->
				<!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

				<div id="login" style="padding:30px; width:80%">

					<div id="container">
						<tiles:insertAttribute name="body" />
					</div>
			</div>
		</div>
	</div>
	</div>


	<div class="fwrapper grids-24">
		<div class="grids-24" id="footer">
			<div class="grid-3 first"></div>
			<div class="grid-21 last">
				<p>
					Department of Computer Science, 226 Atanasoff Hall, (515) 294-4377,
					<script>
						document.write('<a href="mailto:'
								+ [ "csdept", "iastate.edu" ].join('@') + '">'
								+ [ "csdept", "iastate.edu" ].join('@')
								+ '</a>')
					</script>
				<noscript>csdept (at) iastate (dot) edu</noscript>
				.
				</p>
				<p>Copyright &copy; 1995-2014, Iowa State University of Science
					and Technology. All rights reserved.</p>
			</div>
		</div>
	</div>

</body>
</html>