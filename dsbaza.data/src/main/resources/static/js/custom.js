$(document).ready(function() {

    $('#autocomplete-input').devbridgeAutocomplete({
        serviceUrl: '/suggestion',
        paramName: 'searchstr',
        minChars: 1,
        autoSelectFirst: true,
    });

});

$(document).ready(function() {

    $('#autocomplete-input2').devbridgeAutocomplete({
        serviceUrl: '/suggestion2',
        paramName: 'searchstr2',
        minChars: 1,
        autoSelectFirst: true,
    });

});

$(document).ready(function() {

    $('#autocomplete-input3').devbridgeAutocomplete({
        serviceUrl: '/suggestion3',
        paramName: 'searchstr3',
        minChars: 1,
        autoSelectFirst: true,
    });

});

$(document).ready(function() {

    $('#autocomplete-input4').devbridgeAutocomplete({
        serviceUrl: '/suggestion4',
        paramName: 'searchstr4',
        minChars: 1,
        autoSelectFirst: true,
    });

});

$(function () {
    $('#datetimepicker10').datetimepicker({
        format: "DD.MM.YYYY"
    });
});

$(function () {
    var body = $("body");

    var previousWidth = null;

    // Function that applies padding to the body
    // to adjust its position.
    var resizeBody = function () {
        var currentWidth = body.width();
        if (currentWidth != previousWidth) {
            previousWidth = currentWidth;

            // Measure the scrollbar size
            body.css("overflow", "hidden");
            var scrollBarWidth = body.width() - currentWidth;
            body.css("overflow", "auto");

            body.css("margin-left", scrollBarWidth + "px");
        }
    };

    // setInterval is required because the resize event
    // is not fired when a scrollbar appears or disappears.
    setInterval(resizeBody, 100);
    resizeBody();
});



//BRISI SVE OVO

// var currentTab = 0; // Current tab is set to be the first tab (0)
// showTab(currentTab); // Display the current tab
//
// function showTab(n) {
//     // This function will display the specified tab of the form ...
//     var x = document.getElementsByClassName("tab");
//     x[n].style.display = "block";
//     // ... and fix the Previous/Next buttons:
//     if (n == 0) {
//         document.getElementById("prevBtn").style.display = "none";
//     } else {
//         document.getElementById("prevBtn").style.display = "inline";
//     }
//     if (n == (x.length - 1)) {
//         document.getElementById("nextBtn").innerHTML = "Submit";
//     } else {
//         document.getElementById("nextBtn").innerHTML = "Next";
//     }
//     // ... and run a function that displays the correct step indicator:
//     fixStepIndicator(n)
// }
//
// function nextPrev(n) {
//     // This function will figure out which tab to display
//     var x = document.getElementsByClassName("tab");
//     // Exit the function if any field in the current tab is invalid:
//     if (n == 1 && !validateForm()) return false;
//     // Hide the current tab:
//     x[currentTab].style.display = "none";
//     // Increase or decrease the current tab by 1:
//     currentTab = currentTab + n;
//     // if you have reached the end of the form... :
//     if (currentTab >= x.length) {
//         //...the form gets submitted:
//         document.getElementById("regForm").submit();
//         return false;
//     }
//     // Otherwise, display the correct tab:
//     showTab(currentTab);
// }
//
// function validateForm() {
//     // This function deals with validation of the form fields
//     var x, y, i, valid = true;
//     x = document.getElementsByClassName("tab");
//     y = x[currentTab].getElementsByTagName("input");
//     // A loop that checks every input field in the current tab:
//     for (i = 0; i < y.length; i++) {
//         // If a field is empty...
//         if (y[i].value == "") {
//             // add an "invalid" class to the field:
//             y[i].className += " invalid";
//             // and set the current valid status to false:
//             valid = false;
//         }
//     }
//     // If the valid status is true, mark the step as finished and valid:
//     if (valid) {
//         document.getElementsByClassName("step")[currentTab].className += " finish";
//     }
//     return valid; // return the valid status
// }
//
// function fixStepIndicator(n) {
//     // This function removes the "active" class of all steps...
//     var i, x = document.getElementsByClassName("step");
//     for (i = 0; i < x.length; i++) {
//         x[i].className = x[i].className.replace(" active", "");
//     }
//     //... and adds the "active" class to the current step:
//     x[n].className += " active";
// }
