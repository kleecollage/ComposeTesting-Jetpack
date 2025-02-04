package com.kleecollage.jetpacktesting.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class DialogComponentTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetTrue_thenShowDialog() {
        composeTestRule.setContent {
            AddTasksDialog(show = true, onDismiss = {}, onTaskAdded = {} )
        }

        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetFalse_thenHideDialog() {
        composeTestRule.setContent {
            AddTasksDialog(show = false, onDismiss = {}, onTaskAdded = {} )
        }

        // composeTestRule.onNodeWithTag("dialog").assertIsNotDisplayed()
        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }

}