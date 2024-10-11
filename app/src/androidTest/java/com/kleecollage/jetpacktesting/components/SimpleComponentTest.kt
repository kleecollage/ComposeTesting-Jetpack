package com.kleecollage.jetpacktesting.components

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

class SimpleComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            SimpleComponent()
        }
        // ==============================   FINDERS   ============================== //
        composeTestRule.onNodeWithText("doe", ignoreCase = true)
        composeTestRule.onNodeWithTag("textFieldName")
        composeTestRule.onNodeWithContentDescription("Image")

        composeTestRule.onAllNodesWithTag("textGreeting")
        composeTestRule.onAllNodesWithText("j")
        composeTestRule.onAllNodesWithContentDescription("Icon")

        // ==============================   ACTIONS   ============================== //
        composeTestRule.onNodeWithText("doe", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("j").onFirst().performClick()

        composeTestRule.onNodeWithText("doe")
            .performTouchInput { longClick(); doubleClick(); swipeDown(); swipeUp(); swipeLeft(); swipeRight() }

        composeTestRule.onNodeWithText("doe")
            .performScrollTo()
            .performClick()
            .performTextInput("Multiple performs actions")

        composeTestRule.onNodeWithText("doe").performImeAction()
        composeTestRule.onNodeWithText("doe").performTextClearance()
        composeTestRule.onNodeWithText("doe").performTextInput("Testing text input")
        composeTestRule.onNodeWithText("doe").performTextReplacement("Testing replacement text")

        // ==============================   ASSERTIONS ==============================   //
        composeTestRule.onNodeWithText("doe").assertExists()
        composeTestRule.onNodeWithText("doe").assertDoesNotExist()
        composeTestRule.onNodeWithText("doe").assertContentDescriptionEquals("Image")
        composeTestRule.onNodeWithText("doe").assertContentDescriptionContains("Ic")
        composeTestRule.onNodeWithText("doe").assertIsDisplayed()
        composeTestRule.onNodeWithText("doe").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("doe").assertIsEnabled()
        composeTestRule.onNodeWithText("doe").assertIsNotEnabled()
        composeTestRule.onNodeWithText("doe").assertIsSelected()
        composeTestRule.onNodeWithText("doe").assertIsNotSelected()
        composeTestRule.onNodeWithText("doe").assertIsFocused()
        composeTestRule.onNodeWithText("doe").assertIsNotFocused()
        composeTestRule.onNodeWithText("doe").assertIsOn()
        composeTestRule.onNodeWithText("doe").assertIsOff()
        composeTestRule.onNodeWithText("doe").assertTextEquals("Jhon Doe")
        composeTestRule.onNodeWithText("doe").assertTextContains("oe")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsJohn() {
        composeTestRule.setContent {
            SimpleComponent()
        }

        composeTestRule.onNodeWithText("john doe", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("John Doe")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            SimpleComponent()
        }
        composeTestRule.onNodeWithTag("textFieldName").performTextClearance() // se ahorra esta linea con replacement
        composeTestRule.onNodeWithTag("textFieldName").performTextInput("Klee")
        composeTestRule.onNodeWithTag("textGreeting").assertTextContains("Te llamas Klee")
    }

}
















