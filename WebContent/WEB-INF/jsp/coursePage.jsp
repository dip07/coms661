<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="grids-24">

	<div class="grid-24" id="content" style="margin: 0;">


		<!-- end of common header part  -->


		<!-- the content of this page -->






		<!-- welcome header -->
		<div id="note">

			<div id="title">
				<h1>Dipanjan Karmakar</h1>
				<h2>student</h2>
			</div>
			<ul id="list">
				<li><a class="semester"> </a></li>
				<li class="link"><a
					href="https://ta.cs.iastate.edu:8443/TAApp/changeSemester">Change Semester</a></li>
				<li class="link"><a
					href="https://ta.cs.iastate.edu:8443/TAApp/home">Main Page</a></li>
				<li class="link"><a
					href="https://ta.cs.iastate.edu:8443/TAApp/logout">Logout</a></li>
			</ul>
		</div>

		<div class="gutter">

			<script src="TA%20Application%20System%20Main%20page_files/jquery.js"></script>
			<script src="TA%20Application%20System%20Main%20page_files/chosen.js"></script>
			<script
				src="TA%20Application%20System%20Main%20page_files/jquery_002.js"></script>
			<script
				src="TA%20Application%20System%20Main%20page_files/jquery_003.js"></script>
			<link href="TA%20Application%20System%20Main%20page_files/chosen.css"
				rel="stylesheet" media="screen">
			<script type="text/javascript">
    $(document).ready(function() {
        $("#application").validate({
            rules: {
                form_param_full_name: "required",
                form_param_student_id_number: {
                    required: true,
                    number: true
                },
                form_param_phone_number: {
                    required: true,
                    phoneUS: true
                },
                form_param_email: {
                    required: true,
                    email: true
                },
                form_param_current_gpa: {
                    required: true,
                    range: [0, 4],
                    number: true
                },
                form_param_transcript: {
                    required: true,
                    accept: "application/pdf"
                },
                form_param_cv: {
                    required: true,
                    accept: "application/pdf"
                }
            },
            messages: {
                form_param_transcript: {
                    accept: "The file must be in PDF format."
                },
                form_param_cv: {
                    accept: "The file must be in PDF format."
                }
            }
        });
        $(".multiselect").chosen({
            placeholder_text_multiple: "Select classes.",
            no_results_text: "No classes found.",
            width: "300px"
        });
    });
</script>


			<div class="titlebox">
				<div class="left">
					<h1>TA Application</h1>
					<h2>Complete this form to apply for a TA position.</h2>
				</div>
				<div class="right">
					<a class="semester">Spring 2017</a>
				</div>
			</div>



			<div class="form-alert" style="">
				<strong>No more changes are allowed at this time.</strong>
			</div>

			<form id="application" action="TAApplication" method="POST"
				enctype="multipart/form-data" novalidate="novalidate">

				<input name="form_param_post_source"
					value="WEB-INF/TAApplicationView.jsp" type="hidden">

				<fieldset class="form-horizontal">
					<legend>Personal Information</legend>

					<div class="group">
						<label for="full_name">Full name:</label>
						<div class="controls">
							<input id="full_name" name="form_param_full_name"
								value="Dipanjan Karmakar" type="text">
						</div>
					</div>

					<div class="group">
						<label for="student_id_number">Student ID number:</label>
						<div class="controls">
							<input id="student_id_number" name="form_param_student_id_number"
								value="unknown number" type="text">
						</div>
					</div>
					<div class="group">
						<label for="phone_number">Phone number:</label>
						<div class="controls">
							<input id="phone_number" name="form_param_phone_number"
								value="5157356349" type="text">
						</div>
					</div>
					<div class="group">
						<label for="email">Email:</label>
						<div class="controls">
							<input id="email" name="form_param_email"
								value="dipanjan@iastate.edu" type="text">
						</div>
					</div>
				</fieldset>

				<fieldset class="form-horizontal">
					<legend>Academic Information</legend>

					<div class="group">
						<label for="advisor_name">Advisor name:</label>
						<div class="controls">
							<input id="advisor_name" name="form_param_advisor_name"
								value="Pavan Aduri" type="text"> <label
								for="advisor_name">(Optional) Leave blank if you don't
								have one yet.</label>
						</div>

					</div>

					<div class="group">
						<label for="current_major">Current Major:</label>
						<div class="controls">
							<select id="current_major" name="form_param_current_major">
								<option selected="selected">COM S</option>
								<option>SE</option>
								<option>OTHER</option>
							</select>
						</div>
					</div>

					<div class="group">
						<label for="degree_sought">Degree Sought:</label>
						<div class="controls">
							<select id="degree_sought" name="form_param_degree_sought">
								<option>B.S.</option>
								<option selected="selected">M.S.</option>
								<option>Ph.D.</option>
							</select>
						</div>
					</div>

					<div class="group">
						<label for="current_gpa">Current GPA:</label>
						<div class="controls">
							<input id="current_gpa" name="form_param_current_gpa"
								value="3.13" type="text">
						</div>
					</div>

					<div class="group">
						<label for="courses_got_a_or_a_minus">Courses finished
							with an A or A-:</label>
						<div class="controls">
							<select id="courses_got_a_or_a_minus"
								name="form_param_courses_got_a_or_a_minus" multiple="multiple"
								class="multiselect" style="display: none;">

								<option>101</option>

								<option>103</option>

								<option>104</option>

								<option>106X</option>

								<option>107</option>

								<option>108</option>

								<option>113X</option>

								<option>201</option>

								<option>203</option>

								<option>207</option>

								<option>208</option>

								<option>227</option>

								<option>228</option>

								<option>229</option>

								<option>252</option>

								<option>290</option>

								<option>309</option>

								<option>311</option>

								<option>319</option>

								<option>321</option>

								<option>330</option>

								<option>331</option>

								<option>336</option>

								<option>342</option>

								<option>350</option>

								<option>352</option>

								<option>362</option>

								<option>363</option>

								<option>398</option>

								<option>401</option>

								<option>402A</option>

								<option>409/509</option>

								<option>410/510</option>

								<option>412/512</option>

								<option>414/514</option>

								<option>415</option>

								<option>417</option>

								<option>418/518</option>

								<option>421</option>

								<option>424X</option>

								<option>425</option>

								<option>426/526</option>

								<option>430</option>

								<option>433/533</option>

								<option>437</option>

								<option>440/540</option>

								<option>444</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>461/561</option>

								<option>472/572</option>

								<option>474</option>

								<option>477/577</option>

								<option>481</option>

								<option>486</option>

								<option>487/587</option>

								<option>490</option>

								<option>502</option>

								<option>503</option>

								<option>511</option>

								<option>515</option>

								<option>525</option>

								<option>531</option>

								<option>541</option>

								<option>544</option>

								<option>549</option>

								<option>550</option>

								<option>551</option>

								<option>552</option>

								<option>556</option>

								<option>557</option>

								<option>558</option>

								<option>562</option>

								<option>567</option>

								<option>568</option>

								<option>569</option>

								<option>570</option>

								<option>573</option>

								<option>574</option>

								<option>575</option>

								<option>581</option>

								<option>583</option>

								<option>586</option>

								<option>590</option>

								<option>592</option>

								<option>596</option>

								<option>598</option>

								<option>599</option>

								<option>610</option>

								<option>611</option>

								<option>612</option>

								<option>625</option>

								<option>626</option>

								<option>631</option>

								<option>633</option>

								<option>634</option>

								<option>641</option>

								<option>652</option>

								<option>657</option>

								<option>661</option>

								<option>672</option>

								<option>673</option>

								<option>681</option>

								<option>686</option>

								<option>699</option>

								<option>Advising</option>

								<option>Office</option>

								<option>PMsmkautz</option>

								<option>RAhridesh</option>

								<option>RArlutz</option>

								<option>RAwzhang</option>

								<option>SSG</option>

								<option>105X</option>

								<option>402B</option>

								<option>435X/535X</option>

								<option>RAasminer</option>

								<option>RAdstolee</option>

								<option>RAlutz</option>

								<option>RAtavanapo</option>

								<option>113</option>

								<option>113XW</option>

								<option>127X</option>

								<option>327</option>

								<option>412</option>

								<option>441/541</option>

								<option>RAjia</option>

								<option>SWcharris</option>

								<option>103XW</option>

								<option>104XV</option>

								<option>104XW</option>

								<option>107XW</option>

								<option>207XW</option>

								<option>402C</option>

								<option>513X</option>

								<option>AdvisingSE</option>

								<option>PMjia</option>

								<option>Tutoring</option>

								<option>RAciardo</option>

								<option>106</option>

								<option>230</option>

								<option>435/535</option>

								<option selected="selected">561</option>

								<option>665AX</option>

								<option>PMSELC</option>

								<option>106XW</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option>228B</option>

								<option>228C</option>

								<option>407X/507X</option>

								<option>453X</option>

								<option>559X</option>

								<option>560X</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title=""
								id="courses_got_a_or_a_minus_chosen">
								<ul class="chosen-choices">
									<li class="search-choice"><span>561</span><a
										class="search-choice-close" data-option-array-index="141"></a></li>
									<li class="search-field"><input class=""
										autocomplete="off" style="width: 25px;" type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>
					<div class="group">
						<label for="courses_got_b_or_b_minus">Courses finished
							with a B or B+:</label>
						<div class="controls">
							<select id="courses_got_b_or_b_minus"
								name="form_param_courses_got_b_or_b_minus" multiple="multiple"
								class="multiselect" style="display: none;">

								<option>101</option>

								<option>103</option>

								<option>104</option>

								<option>106X</option>

								<option>107</option>

								<option>108</option>

								<option>113X</option>

								<option>201</option>

								<option>203</option>

								<option>207</option>

								<option>208</option>

								<option>227</option>

								<option>228</option>

								<option>229</option>

								<option>252</option>

								<option>290</option>

								<option>309</option>

								<option>311</option>

								<option>319</option>

								<option>321</option>

								<option>330</option>

								<option>331</option>

								<option>336</option>

								<option>342</option>

								<option>350</option>

								<option>352</option>

								<option>362</option>

								<option>363</option>

								<option>398</option>

								<option>401</option>

								<option>402A</option>

								<option>409/509</option>

								<option>410/510</option>

								<option>412/512</option>

								<option>414/514</option>

								<option>415</option>

								<option>417</option>

								<option>418/518</option>

								<option>421</option>

								<option>424X</option>

								<option>425</option>

								<option>426/526</option>

								<option>430</option>

								<option>433/533</option>

								<option>437</option>

								<option>440/540</option>

								<option>444</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>461/561</option>

								<option>472/572</option>

								<option>474</option>

								<option>477/577</option>

								<option>481</option>

								<option>486</option>

								<option>487/587</option>

								<option>490</option>

								<option>502</option>

								<option>503</option>

								<option selected="selected">511</option>

								<option>515</option>

								<option>525</option>

								<option selected="selected">531</option>

								<option>541</option>

								<option>544</option>

								<option>549</option>

								<option>550</option>

								<option>551</option>

								<option>552</option>

								<option>556</option>

								<option>557</option>

								<option>558</option>

								<option>562</option>

								<option>567</option>

								<option>568</option>

								<option>569</option>

								<option>570</option>

								<option>573</option>

								<option>574</option>

								<option>575</option>

								<option>581</option>

								<option>583</option>

								<option>586</option>

								<option>590</option>

								<option>592</option>

								<option>596</option>

								<option>598</option>

								<option>599</option>

								<option>610</option>

								<option>611</option>

								<option>612</option>

								<option>625</option>

								<option>626</option>

								<option>631</option>

								<option>633</option>

								<option>634</option>

								<option>641</option>

								<option>652</option>

								<option>657</option>

								<option>661</option>

								<option>672</option>

								<option>673</option>

								<option>681</option>

								<option>686</option>

								<option>699</option>

								<option>Advising</option>

								<option>Office</option>

								<option>PMsmkautz</option>

								<option>RAhridesh</option>

								<option>RArlutz</option>

								<option>RAwzhang</option>

								<option>SSG</option>

								<option>105X</option>

								<option>402B</option>

								<option>435X/535X</option>

								<option>RAasminer</option>

								<option>RAdstolee</option>

								<option>RAlutz</option>

								<option>RAtavanapo</option>

								<option>113</option>

								<option>113XW</option>

								<option>127X</option>

								<option>327</option>

								<option>412</option>

								<option>441/541</option>

								<option>RAjia</option>

								<option>SWcharris</option>

								<option>103XW</option>

								<option>104XV</option>

								<option>104XW</option>

								<option>107XW</option>

								<option>207XW</option>

								<option>402C</option>

								<option>513X</option>

								<option>AdvisingSE</option>

								<option>PMjia</option>

								<option>Tutoring</option>

								<option>RAciardo</option>

								<option>106</option>

								<option>230</option>

								<option>435/535</option>

								<option>561</option>

								<option>665AX</option>

								<option>PMSELC</option>

								<option>106XW</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option>228B</option>

								<option>228C</option>

								<option>407X/507X</option>

								<option>453X</option>

								<option>559X</option>

								<option>560X</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title=""
								id="courses_got_b_or_b_minus_chosen">
								<ul class="chosen-choices">
									<li class="search-choice"><span>511</span><a
										class="search-choice-close" data-option-array-index="59"></a></li>
									<li class="search-choice"><span>531</span><a
										class="search-choice-close" data-option-array-index="62"></a></li>
									<li class="search-field"><input class=""
										autocomplete="off" style="width: 25px;" type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>
					<div class="group">
						<label for="courses_assisted_in_the_past">Courses TA'ed in
							the past:</label>
						<div class="controls">
							<select id="courses_assisted_in_the_past"
								name="form_param_courses_assisted_in_the_past"
								multiple="multiple" class="multiselect" style="display: none;">

								<option>101</option>

								<option>103</option>

								<option>104</option>

								<option>106X</option>

								<option>107</option>

								<option>108</option>

								<option>113X</option>

								<option>201</option>

								<option>203</option>

								<option>207</option>

								<option>208</option>

								<option>227</option>

								<option>228</option>

								<option>229</option>

								<option>252</option>

								<option>290</option>

								<option selected="selected">309</option>

								<option>311</option>

								<option>319</option>

								<option>321</option>

								<option>330</option>

								<option>331</option>

								<option>336</option>

								<option>342</option>

								<option>350</option>

								<option>352</option>

								<option>362</option>

								<option>363</option>

								<option>398</option>

								<option>401</option>

								<option>402A</option>

								<option>409/509</option>

								<option>410/510</option>

								<option>412/512</option>

								<option>414/514</option>

								<option>415</option>

								<option>417</option>

								<option>418/518</option>

								<option>421</option>

								<option>424X</option>

								<option>425</option>

								<option>426/526</option>

								<option>430</option>

								<option>433/533</option>

								<option>437</option>

								<option>440/540</option>

								<option>444</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>461/561</option>

								<option>472/572</option>

								<option>474</option>

								<option>477/577</option>

								<option>481</option>

								<option>486</option>

								<option>487/587</option>

								<option>490</option>

								<option>502</option>

								<option>503</option>

								<option>511</option>

								<option>515</option>

								<option>525</option>

								<option>531</option>

								<option>541</option>

								<option>544</option>

								<option>549</option>

								<option>550</option>

								<option>551</option>

								<option>552</option>

								<option>556</option>

								<option>557</option>

								<option>558</option>

								<option>562</option>

								<option>567</option>

								<option>568</option>

								<option>569</option>

								<option>570</option>

								<option>573</option>

								<option>574</option>

								<option>575</option>

								<option>581</option>

								<option>583</option>

								<option>586</option>

								<option>590</option>

								<option>592</option>

								<option>596</option>

								<option>598</option>

								<option>599</option>

								<option>610</option>

								<option>611</option>

								<option>612</option>

								<option>625</option>

								<option>626</option>

								<option>631</option>

								<option>633</option>

								<option>634</option>

								<option>641</option>

								<option>652</option>

								<option>657</option>

								<option>661</option>

								<option>672</option>

								<option>673</option>

								<option>681</option>

								<option>686</option>

								<option>699</option>

								<option>Advising</option>

								<option>Office</option>

								<option>PMsmkautz</option>

								<option>RAhridesh</option>

								<option>RArlutz</option>

								<option>RAwzhang</option>

								<option>SSG</option>

								<option>105X</option>

								<option>402B</option>

								<option>435X/535X</option>

								<option>RAasminer</option>

								<option>RAdstolee</option>

								<option>RAlutz</option>

								<option>RAtavanapo</option>

								<option>113</option>

								<option>113XW</option>

								<option>127X</option>

								<option>327</option>

								<option>412</option>

								<option>441/541</option>

								<option>RAjia</option>

								<option>SWcharris</option>

								<option>103XW</option>

								<option>104XV</option>

								<option>104XW</option>

								<option>107XW</option>

								<option>207XW</option>

								<option>402C</option>

								<option>513X</option>

								<option>AdvisingSE</option>

								<option>PMjia</option>

								<option>Tutoring</option>

								<option>RAciardo</option>

								<option>106</option>

								<option>230</option>

								<option>435/535</option>

								<option>561</option>

								<option>665AX</option>

								<option>PMSELC</option>

								<option>106XW</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option>228B</option>

								<option>228C</option>

								<option>407X/507X</option>

								<option>453X</option>

								<option>559X</option>

								<option>560X</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title=""
								id="courses_assisted_in_the_past_chosen">
								<ul class="chosen-choices">
									<li class="search-choice"><span>309</span><a
										class="search-choice-close" data-option-array-index="16"></a></li>
									<li class="search-field"><input class=""
										autocomplete="off" style="width: 25px;" type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>
					<div class="group">
						<label for="courses_taking">Courses taking:</label>
						<div class="controls">
							<select id="courses_taking" name="form_param_courses_taking"
								multiple="multiple" class="multiselect" style="display: none;">

								<option>101</option>

								<option>103</option>

								<option>104</option>

								<option>106X</option>

								<option>107</option>

								<option>108</option>

								<option>113X</option>

								<option>201</option>

								<option>203</option>

								<option>207</option>

								<option>208</option>

								<option>227</option>

								<option>228</option>

								<option>229</option>

								<option>252</option>

								<option>290</option>

								<option>309</option>

								<option>311</option>

								<option>319</option>

								<option>321</option>

								<option>330</option>

								<option>331</option>

								<option>336</option>

								<option>342</option>

								<option>350</option>

								<option>352</option>

								<option>362</option>

								<option>363</option>

								<option>398</option>

								<option>401</option>

								<option>402A</option>

								<option>409/509</option>

								<option>410/510</option>

								<option>412/512</option>

								<option>414/514</option>

								<option>415</option>

								<option>417</option>

								<option>418/518</option>

								<option>421</option>

								<option>424X</option>

								<option>425</option>

								<option>426/526</option>

								<option>430</option>

								<option>433/533</option>

								<option>437</option>

								<option>440/540</option>

								<option>444</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>461/561</option>

								<option>472/572</option>

								<option>474</option>

								<option>477/577</option>

								<option>481</option>

								<option>486</option>

								<option>487/587</option>

								<option>490</option>

								<option>502</option>

								<option>503</option>

								<option>511</option>

								<option>515</option>

								<option>525</option>

								<option>531</option>

								<option>541</option>

								<option>544</option>

								<option>549</option>

								<option>550</option>

								<option>551</option>

								<option>552</option>

								<option>556</option>

								<option>557</option>

								<option>558</option>

								<option>562</option>

								<option>567</option>

								<option>568</option>

								<option>569</option>

								<option>570</option>

								<option>573</option>

								<option>574</option>

								<option>575</option>

								<option>581</option>

								<option>583</option>

								<option>586</option>

								<option>590</option>

								<option>592</option>

								<option>596</option>

								<option>598</option>

								<option>599</option>

								<option>610</option>

								<option>611</option>

								<option>612</option>

								<option>625</option>

								<option>626</option>

								<option>631</option>

								<option>633</option>

								<option>634</option>

								<option>641</option>

								<option>652</option>

								<option>657</option>

								<option>661</option>

								<option>672</option>

								<option>673</option>

								<option>681</option>

								<option>686</option>

								<option>699</option>

								<option>Advising</option>

								<option>Office</option>

								<option>PMsmkautz</option>

								<option>RAhridesh</option>

								<option>RArlutz</option>

								<option>RAwzhang</option>

								<option>SSG</option>

								<option>105X</option>

								<option>402B</option>

								<option>435X/535X</option>

								<option>RAasminer</option>

								<option>RAdstolee</option>

								<option>RAlutz</option>

								<option>RAtavanapo</option>

								<option>113</option>

								<option>113XW</option>

								<option>127X</option>

								<option>327</option>

								<option>412</option>

								<option>441/541</option>

								<option>RAjia</option>

								<option>SWcharris</option>

								<option>103XW</option>

								<option>104XV</option>

								<option>104XW</option>

								<option>107XW</option>

								<option>207XW</option>

								<option>402C</option>

								<option>513X</option>

								<option>AdvisingSE</option>

								<option>PMjia</option>

								<option>Tutoring</option>

								<option>RAciardo</option>

								<option>106</option>

								<option>230</option>

								<option>435/535</option>

								<option>561</option>

								<option>665AX</option>

								<option>PMSELC</option>

								<option>106XW</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option>228B</option>

								<option>228C</option>

								<option>407X/507X</option>

								<option>453X</option>

								<option>559X</option>

								<option>560X</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title="" id="courses_taking_chosen">
								<ul class="chosen-choices">
									<li class="search-field"><input value="Select classes."
										class="default" autocomplete="off" style="width: 112px;"
										type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>

					<div class="group">
						<label for="transcript">Latest unofficial transcript<br>(Upload
							PDF) <font color="red">*</font> :
						</label>
						<div class="controls">
							<input id="transcript" value="browse"
								name="form_param_transcript" type="file"> <label
								for="transcript">(this will be discarded after the
								semester is done)</label>
						</div>
					</div>

					<div class="group">
						<label for="cv">Latest CV/Resumé<br>(Upload PDF) <font
							color="red">*</font> :
						</label>
						<div class="controls">
							<input id="cv" value="browse" name="form_param_cv" type="file">
						</div>
					</div>

				</fieldset>



				<fieldset class="form-horizontal">
					<legend>Skill Levels</legend>



					<div class="group">
						<label>Java</label>
						<div class="controls">

							<select name="form_param_skill_level_27">
								<option value="0">None</option>
								<option value="1">Fair</option>
								<option value="2" selected="selected">Good</option>
								<option value="3">Excellent</option>
							</select>

						</div>
					</div>

					<div class="group">
						<label>C</label>
						<div class="controls">

							<select name="form_param_skill_level_28">
								<option value="0">None</option>
								<option value="1" selected="selected">Fair</option>
								<option value="2">Good</option>
								<option value="3">Excellent</option>
							</select>

						</div>
					</div>

					<div class="group">
						<label>C++</label>
						<div class="controls">

							<select name="form_param_skill_level_29">
								<option value="0">None</option>
								<option value="1" selected="selected">Fair</option>
								<option value="2">Good</option>
								<option value="3">Excellent</option>
							</select>

						</div>
					</div>

					<div class="group">
						<label>Microsoft Word</label>
						<div class="controls">

							<select name="form_param_skill_level_45">
								<option value="0">None</option>
								<option value="1" selected="selected">Fair</option>
								<option value="2">Good</option>
								<option value="3">Excellent</option>
							</select>

						</div>
					</div>

					<div class="group">
						<label for="current_speak_teach_level">Current Speak/Teach Level:</label>
						<div class="controls">
							<select id="current_speak_teach_level"
								name="form_param_current_speak_teach_level">
								<option value="-1">N/A</option>
								<option value="0">Not Taken</option>
								<option value="1">1</option>
								<option value="2" selected="selected">2</option>
								<option value="3">3</option>
							</select>
						</div>
					</div>

				</fieldset>



				<fieldset class="form-horizontal">
					<legend>TA Course Preferences</legend>

					<div class="group">
						<label>Want to do</label>
						<div class="controls">
							<select name="form_param_course_preferences_want"
								multiple="multiple" class="multiselect" style="display: none;">

								<option>103</option>

								<option selected="selected">104</option>

								<option selected="selected">106</option>

								<option>106XW</option>

								<option>107</option>

								<option selected="selected">113</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>113XW</option>

								<option>127X</option>

								<option>203</option>

								<option selected="selected">207</option>

								<option>207XW</option>

								<option selected="selected">227</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option selected="selected">228</option>

								<option>228B</option>

								<option>228C</option>

								<option>230</option>

								<option selected="selected">309</option>

								<option>311</option>

								<option selected="selected">319</option>

								<option>321</option>

								<option>327</option>

								<option>331</option>

								<option>342</option>

								<option selected="selected">352</option>

								<option>362</option>

								<option selected="selected">363</option>

								<option>402B</option>

								<option>407X/507X</option>

								<option>412/512</option>

								<option>418/518</option>

								<option>430</option>

								<option>437</option>

								<option>440/540</option>

								<option>453X</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>474</option>

								<option>486</option>

								<option>487/587</option>

								<option>511</option>

								<option>531</option>

								<option>551</option>

								<option>559X</option>

								<option>560X</option>

								<option>573</option>

								<option>575</option>

								<option>634</option>

								<option>661</option>

								<option>673</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title="">
								<ul class="chosen-choices">
									<li class="search-choice"><span>104</span><a
										class="search-choice-close" data-option-array-index="1"></a></li>
									<li class="search-choice"><span>106</span><a
										class="search-choice-close" data-option-array-index="2"></a></li>
									<li class="search-choice"><span>113</span><a
										class="search-choice-close" data-option-array-index="5"></a></li>
									<li class="search-choice"><span>207</span><a
										class="search-choice-close" data-option-array-index="13"></a></li>
									<li class="search-choice"><span>227</span><a
										class="search-choice-close" data-option-array-index="15"></a></li>
									<li class="search-choice"><span>228</span><a
										class="search-choice-close" data-option-array-index="19"></a></li>
									<li class="search-choice"><span>309</span><a
										class="search-choice-close" data-option-array-index="23"></a></li>
									<li class="search-choice"><span>319</span><a
										class="search-choice-close" data-option-array-index="25"></a></li>
									<li class="search-choice"><span>352</span><a
										class="search-choice-close" data-option-array-index="30"></a></li>
									<li class="search-choice"><span>363</span><a
										class="search-choice-close" data-option-array-index="32"></a></li>
									<li class="search-field"><input class=""
										autocomplete="off" style="width: 25px;" type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>

					<div class="group">
						<label>Willing to do (can be persuaded)</label>
						<div class="controls">
							<select name="form_param_course_preferences_willing"
								multiple="multiple" class="multiselect" style="display: none;">

								<option>103</option>

								<option>104</option>

								<option>106</option>

								<option>106XW</option>

								<option>107</option>

								<option>113</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>113XW</option>

								<option>127X</option>

								<option>203</option>

								<option>207</option>

								<option>207XW</option>

								<option>227</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option>228</option>

								<option>228B</option>

								<option>228C</option>

								<option>230</option>

								<option>309</option>

								<option>311</option>

								<option>319</option>

								<option>321</option>

								<option>327</option>

								<option>331</option>

								<option>342</option>

								<option>352</option>

								<option selected="selected">362</option>

								<option>363</option>

								<option>402B</option>

								<option>407X/507X</option>

								<option>412/512</option>

								<option>418/518</option>

								<option>430</option>

								<option>437</option>

								<option>440/540</option>

								<option>453X</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>474</option>

								<option>486</option>

								<option>487/587</option>

								<option>511</option>

								<option>531</option>

								<option>551</option>

								<option>559X</option>

								<option>560X</option>

								<option>573</option>

								<option>575</option>

								<option>634</option>

								<option>661</option>

								<option>673</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title="">
								<ul class="chosen-choices">
									<li class="search-choice"><span>362</span><a
										class="search-choice-close" data-option-array-index="31"></a></li>
									<li class="search-field"><input class=""
										autocomplete="off" style="width: 25px;" type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>

					<div class="group">
						<label>Would rather not do</label>
						<div class="controls">
							<select name="form_param_course_preferences_wont"
								multiple="multiple" class="multiselect" style="display: none;">

								<option>103</option>

								<option>104</option>

								<option>106</option>

								<option>106XW</option>

								<option>107</option>

								<option>113</option>

								<option>113ABus</option>

								<option>113BBus</option>

								<option>113Cnonbus</option>

								<option>113Dnonbus</option>

								<option>113XW</option>

								<option>127X</option>

								<option>203</option>

								<option>207</option>

								<option>207XW</option>

								<option>227</option>

								<option>227A</option>

								<option>227B</option>

								<option>227C</option>

								<option>228</option>

								<option>228B</option>

								<option>228C</option>

								<option>230</option>

								<option>309</option>

								<option>311</option>

								<option>319</option>

								<option>321</option>

								<option>327</option>

								<option>331</option>

								<option>342</option>

								<option>352</option>

								<option>362</option>

								<option>363</option>

								<option>402B</option>

								<option>407X/507X</option>

								<option>412/512</option>

								<option>418/518</option>

								<option>430</option>

								<option>437</option>

								<option>440/540</option>

								<option>453X</option>

								<option>454/554</option>

								<option>455/555</option>

								<option>474</option>

								<option>486</option>

								<option>487/587</option>

								<option>511</option>

								<option>531</option>

								<option>551</option>

								<option>559X</option>

								<option>560X</option>

								<option>573</option>

								<option>575</option>

								<option>634</option>

								<option>661</option>

								<option>673</option>

								<option>LAS350A</option>

							</select>
							<div class="chosen-container chosen-container-multi"
								style="width: 300px;" title="">
								<ul class="chosen-choices">
									<li class="search-field"><input value="Select classes."
										class="default" autocomplete="off" style="width: 112px;"
										type="text"></li>
								</ul>
								<div class="chosen-drop">
									<ul class="chosen-results"></ul>
								</div>
							</div>
						</div>
					</div>

					<div class="group">
						<label>Hours/week you are willing to work:</label>
						<div class="controls">
							<select name="form_param_hours_per_week">
								<option>5</option>
								<option selected="selected">10</option>
								<option>15</option>
								<option>20</option>

							</select>
						</div>
					</div>

					<div class="group">
						<label>Comments:<br>(e.g. Leave during spring break,
							up to 300 characters.)
						</label><br>
						<div class="controls">
							<textarea rows="5" cols="35" maxlength="300"
								name="form_param_comments">Will be on vacation till 13th Jan. Going to home. Able to join on 16th Jan.</textarea>
						</div>
					</div>


				</fieldset>


			</form>



			<!-- end of the content of this page -->

			<!-- common footer part -->
			
			<fieldset class="form-horizontal">
					<legend>Enter course information -- @ Dipanjan</legend>
					
					<div class="group">
						<label>Year</label>
						<div class="controls">
							<p><input type="text" id="yearpicker" /></p>

						</div>
					</div>
					
					<div class="group">
						<label>Session</label>
						<div class="controls">

							<select name="form_param_skill_level_45">
								<option value="Fall" selected="selected">Fall</option>
								<option value="Spring">Spring</option>
								<option value="Summer">Summer</option>
							</select>

						</div>
					</div>
					
					<div class="group">
						<label>Course</label>
						<div class="controls">

							<%-- <form:select>
    							<form:options items="${courseList.courses}" />
							</form:select> --%>
							
							<select name="courseName">
    							<c:forEach items="${courseList.courses}" var="course">
        							<option value="${course.courseNumber}" selected=${course == selectedCourse ? 'selected' : ''}>${course.courseName}</option>
    							</c:forEach>
							</select>

						</div>
					</div>
					
			</fieldset>

		</div>
	</div>
</div>
