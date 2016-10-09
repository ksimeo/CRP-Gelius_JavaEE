<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<!-- FORM VALIDATION -->
<script type="text/javascript">
    //Value of 'btn' set via onclick on submit/clear buttons at end of form
    var btn = "";

    function validate(myform) {
        if (btn == "submit") {
            //Validate Form only on 'submit' button (not for 'clear' button)
            var num = 0;
            var message = "";
            if(myform.name.value == "") {
                message += "- Group Name must be completed \n";
                num = 1;
            }
            if(myform.highschool.value == "") {
                message += "- High School must be completed \n";
                num = 1;
            }
            if(myform.teacher.value == "") {
                message += "- Teacher must be completed \n";
                num = 1;
            }
            if(myform.classPeriod.value == "") {
                message += "- Period must be completed \n";
                num = 1;
            }
            if(myform.surveyStartDate.value == "") {
                message += "- Survey Start Date must be completed \n";
                num = 1;
            }
            if(myform.surveyEndDate.value == "") {
                message += "- Survey End Date must be completed \n";
                num = 1;
            }
            if(myform.eventDate.value == "") {
                message += "- Event Date must be completed \n";
                num = 1;
            }

            if (num == 1) {
                alert ("Please complete or correct the following required fields: \n\n"+message);
                return false;
            } else {
                return true;
            } //end if
        } //end button if
    } //end func
</script>
<body>
<div id="wrapper">

    <!--HEADER-->
    <div id="header">

        <img id="logoImg" src="images/cislogo.png" width="200" height="150" alt="Communities In Schools Logo">


        <!--Header Text-->
        <img id="headerText" src="images/realityuhead.png" width="600" height="80" alt="Reality University Program">
        <!--REALITY U LOGO-->
        <img id="logoImnewGrp" src="images/realityulogo.png" width="100" height="95" alt="Reality U Logo">

        <!--NAVIGATION-->
        <div id="nav">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="adminhome.jsp">Admin Home</a></li>
                <li><a href="newgroup.jsp">New Group</a></li>
                <li><a href="opengroup.jsp">Open Group</a></li>
                <li><a href="occupations.jsp">Edit Occupations</a></li>
                <li><a href="helpadmin.html">Help</a></li>
            </ul>
        </div><!--END NAVIGATION-->


    </div><!--END HEADER-->




    <!--MAIN CONTENT CONTAINER -->
    <div id="main">

        <br><br>

        <fieldset>
            <h3>Admininstration - Add New Group</h3>
        </fieldset>



        <br><br>

        <div id="mainArea">

            <!--START FORM-->
            <form id="newGroupForm" method="post" action="http://localhost:8080/RealityUWeb/NewGroupServlet" onSubmit="return validate(this);">

                <fieldset>
                    <br><br>

                        <%
//If form never been filled in yet, all values are blank
if (session.getAttribute("newGrp") == null) {
%>

                    <div>
                        <label for="name">Group Name:</label>
                        <input type="text" name="name" value="">
                    </div>
                    <div>
                        <label for="highschool">High School:</label>
                        <input type="text" name="highschool" value="">
                    </div>
                    <div>
                        <label for="teacher">Teacher:</label>
                        <input type="text" name="teacher" value="">
                    </div>
                    <div>
                        <label for="classPeriod">Period:</label>
                        <input type="text" name="classPeriod" value="">
                    </div>
                    <div>
                        <label for="surveyStartDate">Survey Start Date:</label>
                        <input type="text" name="surveyStartDate" value="">
                    </div>
                    <div>
                        <label for="surveyEndDate">Survey End Date:</label>
                        <input type="text" name="surveyEndDate" value="">
                    </div>

                    <div>
                        <label for="eventDate">Event Date:</label>
                        <input type="text" name="eventDate" value="">
                    </div>
                    <div>
                        <label for="studentAccessCode">Student Access Code:</label>
                        <input type="text" name="studentAccessCode" value="(Auto-Generated after Submit)" readonly>
                    </div>
</body>
</html>