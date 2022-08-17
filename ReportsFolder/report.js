$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "  As a user, I want to login to KatOne system",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Login successfull",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Success"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.step({
  "name": "I input valid email \u003cemail\u003e and password \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.step({
  "name": "I should be able to login successfully with correct \u003cemail\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "pgialinh.iuetv+1@gmail.com",
        "Abcd@1234"
      ]
    },
    {
      "cells": [
        "pgialinh.iuetv+2@gmail.com",
        "Abcd@1234"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login successfull",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Success"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I input valid email pgialinh.iuetv+1@gmail.com and password Abcd@1234",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.I_enter_email_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to login successfully with correct pgialinh.iuetv+1@gmail.com",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.I_should_be_able_to_login_successfully(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login successfull",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Success"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I input valid email pgialinh.iuetv+2@gmail.com and password Abcd@1234",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.I_enter_email_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should be able to login successfully with correct pgialinh.iuetv+2@gmail.com",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.I_should_be_able_to_login_successfully(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login failed",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Failed"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.step({
  "name": "I input invalid email \u003cemail\u003e or password \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.step({
  "name": "Error messages about invalid credential are shown",
  "keyword": "Then "
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "pGiaLinhIuetv@gmail.com",
        "Abcd@1234"
      ]
    },
    {
      "cells": [
        "pgialinh.iuetv+2@gmail.com",
        "abcd1234"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login failed",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Failed"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I input invalid email pGiaLinhIuetv@gmail.com or password Abcd@1234",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.I_enter_invaid_email_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error messages about invalid credential are shown",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.loginFail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login failed",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Failed"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I input invalid email pgialinh.iuetv+2@gmail.com or password abcd1234",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.I_enter_invaid_email_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error messages about invalid credential are shown",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.loginFail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with empty email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Empty_Email"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.step({
  "name": "I left email field blank",
  "keyword": "When "
});
formatter.step({
  "name": "I may input password \u003cpassword\u003e or left it blank",
  "keyword": "And "
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.step({
  "name": "An error message is shown on the email field",
  "keyword": "Then "
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "password"
      ]
    },
    {
      "cells": [
        ""
      ]
    },
    {
      "cells": [
        "abcd1234"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login with empty email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Empty_Email"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I left email field blank",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.empty_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I may input password  or left it blank",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_input_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "An error message is shown on the email field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.Error_message_is_shown_on_the_email_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with empty email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Empty_Email"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I left email field blank",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.empty_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I may input password abcd1234 or left it blank",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_input_password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "An error message is shown on the email field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.Error_message_is_shown_on_the_email_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with empty password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Empty_Password"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.step({
  "name": "I left password field blank",
  "keyword": "When "
});
formatter.step({
  "name": "I only input valid email \u003cemail\u003e",
  "keyword": "And "
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.step({
  "name": "An error message is shown on the password field",
  "keyword": "Then "
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email"
      ]
    },
    {
      "cells": [
        "mail@mail.com"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login with empty password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Empty_Password"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I left password field blank",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.empty_password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I only input valid email mail@mail.com",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_input_valid_email(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "An error message is shown on the password field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.Error_message_is_shown_on_the_password_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Login with invalid email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Wrong_Email"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.step({
  "name": "I only input invalid email \u003cemail\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.step({
  "name": "An error message about invalid email \u003cemail\u003e is shown on the email field",
  "keyword": "Then "
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email"
      ]
    },
    {
      "cells": [
        "a"
      ]
    },
    {
      "cells": [
        "@"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login with invalid email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Wrong_Email"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I only input invalid email a",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.I_input_invalid_email(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "An error message about invalid email a is shown on the email field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.Show_Error_message_Invalid_Email(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login with invalid email",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Wrong_Email"
    }
  ]
});
formatter.step({
  "name": "I navigate to KatOne url",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDef.I_navigate_to_KatOne_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I only input invalid email @",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStepDef.I_input_invalid_email(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click the submit button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_click_the_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "An error message about invalid email @ is shown on the email field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.Show_Error_message_Invalid_Email(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should NOT be able to login",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStepDef.I_should_not_login()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("Include/features/VerifyEmail.feature");
formatter.feature({
  "name": "Verify email in Profile",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@VerifyEmail"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Verify email in Profile",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@InProfilePage"
    }
  ]
});
formatter.step({
  "name": "I logged in with email \u003cemail\u003e and password \u003cpassword\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I verify the email \u003cemail\u003e in profile page",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "pgialinh.iuetv+1@gmail.com",
        "Abcd@1234"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify email in Profile",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@VerifyEmail"
    },
    {
      "name": "@InProfilePage"
    }
  ]
});
formatter.step({
  "name": "I logged in with email pgialinh.iuetv+1@gmail.com and password Abcd@1234",
  "keyword": "Given "
});
formatter.match({
  "location": "VerifyEmailStepDef.I_logged_in(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I verify the email pgialinh.iuetv+1@gmail.com in profile page",
  "keyword": "Then "
});
formatter.match({
  "location": "VerifyEmailStepDef.I_verify_email(String)"
});
formatter.result({
  "status": "passed"
});
});