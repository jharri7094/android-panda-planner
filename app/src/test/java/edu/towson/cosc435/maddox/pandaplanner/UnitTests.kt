package edu.towson.cosc435.maddox.pandaplanner

import org.junit.Rule;
import org.junit.Test;
import androidx.compose.ui.test.junit4.createAndroidComposeRule;
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.login.LoginViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent.AddEventViewModel
import edu.towson.cosc435.maddox.pandaplanner.ui.screens.signup.SignupViewModel

import org.junit.Assert.*

class UnitTests {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    //1
    @Test
    fun testLoginChangeUsername() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: LoginViewModel = viewModel()
            assertNotNull(vm.username)
            val username = "helloPanda"

            vm.setUsername(username)

            assertEquals("helloPanda", vm.username)
        }
    }

    //2
    @Test
    fun testLoginChangePassword() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: LoginViewModel = viewModel()
            assertNotNull(vm.password)

            val password = "helloPanda"

            vm.setPassword(password)

            assertEquals("helloPanda", vm.password)
        }
    }

    //3
    @Test
    fun testSignUpChangeUsername() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: SignupViewModel = viewModel()
            assertNotNull(vm.username)
            val username = "helloPanda"

            vm.setUsername(username)

            assertEquals("helloPanda", vm.username)
        }
    }

    //4
    @Test
    fun testSignUpChangePassword() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: SignupViewModel = viewModel()
            assertNotNull(vm.password)
            val password = "helloPanda"

            vm.setPassword(password)

            assertEquals("helloPanda", vm.password)
        }
    }

    //5
    @Test
    fun testAddEventStartDate() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.startDate)
            val startDate = "1/1/22"

            vm.setStartDate(startDate)

            assertEquals("1/1/22", vm.startDate)
        }
    }

    //6
    @Test
    fun testAddEventEndDate() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.endDate)
            val endDate = "1/1/22"

            vm.setEndDate(endDate)

            assertEquals("1/1/22", vm.endDate)
        }
    }

    //7
    @Test
    fun testAddEventEventName() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.eventName)
            val eventName = "test"

            vm.setEndDate(eventName)

            assertEquals("test", vm.eventName)
        }
    }

    //8
    @Test
    fun testAddEventEndDetails() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.eventDetails)
            val eventDetails = "test details"

            vm.setEndDate(eventDetails)

            assertEquals("test details", vm.eventDetails)
        }
    }

    //9
    @Test
    fun testAddEventIsCompleted() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.isCompleted)
            val eventCompleted = true

            vm.setIsCompleted(eventCompleted)

            assertEquals(true, vm.isCompleted)
        }
    }

    //10
    @Test
    fun testAddEventPriority() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.selectedPriority)
            val selectedPriority = "High"

            vm.setPriority(selectedPriority)

            assertEquals("High",  vm.selectedPriority)

        }
    }

    //11
    @Test
    fun testAddEventShowDialog() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.showValidationErrorDialog)
            vm.showValidationErrorDialog.value = false

            vm.toggleShowValidationErrorDialog()

            assertEquals(true,  vm.showValidationErrorDialog.value)

        }
    }

    //12
    @Test
    fun testLoginNavigate() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: LoginViewModel = viewModel()
            assertNotNull(vm.navigate)
            vm.navigate.value = false

            vm.toggleNavigate()

            assertEquals(true,  vm.navigate.value)

        }
    }

    //13
    @Test
    fun testLoginNavigateFail() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: LoginViewModel = viewModel()
            assertNotNull(vm.navigate)
            vm.navigate.value = false

            vm.toggleNavigate()
            vm.toggleNavigate()

            assertNotEquals(true,  vm.navigate.value)

        }
    }

    //14
    @Test
    fun testAddEventShowDialogFail() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.showValidationErrorDialog)
            vm.showValidationErrorDialog.value = false

            vm.toggleShowValidationErrorDialog()
            vm.toggleShowValidationErrorDialog()

            assertNotEquals(true,  vm.showValidationErrorDialog.value)

        }
    }

    //15
    @Test
    fun testAddEventPriorityFail() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {

            val vm: AddEventViewModel = viewModel()
            assertNotNull(vm.selectedPriority)
            val selectedPriority = "High"

            vm.setPriority(selectedPriority)

            assertNotEquals("Low",  vm.selectedPriority)

        }
    }



}

//validation of username and password
//validation of database
//validation of passwords matching