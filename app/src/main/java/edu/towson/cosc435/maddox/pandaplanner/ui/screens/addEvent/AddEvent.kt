package edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent

import android.app.Application
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.towson.cosc435.maddox.pandaplanner.data.EventsRepository
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.model.Priority
import edu.towson.cosc435.maddox.pandaplanner.ui.components.GenericText
import edu.towson.cosc435.maddox.pandaplanner.ui.components.SmallHeader
import edu.towson.cosc435.maddox.pandaplanner.ui.components.bambooBrownButton
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme

@ExperimentalComposeUiApi
@Composable
fun AddEvent(
    vm: AddEventViewModel,
    onAddEvent: (Event) -> Unit,
    onCancel : ()->Unit
) {
    val (startDateTf, endDateTf, eventNameTf, eventDetailsTf, priorityTf) = remember { FocusRequester.createRefs() }
    LaunchedEffect(true) {
        startDateTf.requestFocus()
    }
    if (vm.showValidationErrorDialog.value)
    {
        AlertDialog(onDismissRequest = { vm.toggleShowValidationErrorDialog() },
            buttons =
            {
            bambooBrownButton(
                onClick =
                { vm.toggleShowValidationErrorDialog()
                },
                text = "Okay")
            },
            title = { Text(text = "ERROR : Invalid Event") },
            text = { Text(text = "Date and event name fields cannot be blank.") }
        )
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
    ) {
        SmallHeader(Text = "Add a new event")
        OutlinedTextField(
            value = vm.startDate.value,
            onValueChange = { vm.setStartDate(it) },
            placeholder = {
                GenericText("Start Date")
            },
            label = {
                GenericText("Start Date")
            },
            singleLine = true,
            modifier = Modifier
                .focusRequester(startDateTf),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onNext = { endDateTf.requestFocus() }
            )
        )
        OutlinedTextField(
            value = vm.endDate.value,
            onValueChange = vm::setEndDate,
            placeholder = {
                GenericText("End Date")
            },
            singleLine = true,
            label = {
                GenericText("End Date")
            },
            modifier = Modifier
                .focusRequester(endDateTf),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onNext = { eventNameTf.requestFocus() }
            )
        )
        OutlinedTextField(
            value = vm.eventName.value,
            onValueChange = vm::setEventName,
            placeholder = {
                GenericText("Event Name")
            },
            label = {
                GenericText("Event Name")
            },
            singleLine = true,
            modifier = Modifier
                .focusRequester(eventNameTf),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onNext = { eventDetailsTf.requestFocus() }
            )
        )
        OutlinedTextField(
            value = vm.eventDetails.value,
            onValueChange = vm::setEventDetails,
            placeholder = {
                GenericText("Event Details")
            },
            label = {
                GenericText("Event Details")
            },
            singleLine = true,
            modifier = Modifier
                .focusRequester(eventDetailsTf),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onNext = { priorityTf.requestFocus() }
            )
        )
        Row(modifier = Modifier
            .padding(16.dp)
            .focusRequester(priorityTf)) {
            GenericText("Priority: ")

            GenericText(Text = "Low",
                fontWeight =if (vm.selectedPriority.value==Priority.LOW) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier
                    .clickable { vm.setPriority("Low") }
                    .alpha(if (vm.selectedPriority.value == Priority.LOW) 1f else .5f))

            GenericText(Text = "Medium",
                fontWeight =if (vm.selectedPriority.value==Priority.MEDIUM) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier
                    .clickable { vm.setPriority("Medium") }
                    .alpha(if (vm.selectedPriority.value == Priority.MEDIUM) 1f else .5f))

            GenericText(Text = "High",
                fontWeight =if (vm.selectedPriority.value==Priority.HIGH) FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier
                    .clickable { vm.setPriority("High") }
                    .alpha(if (vm.selectedPriority.value == Priority.HIGH) 1f else .5f))

        }

        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Task Completed",
                modifier = Modifier.padding(end = 5.dp)
            )
            Checkbox(
                checked = vm.isCompleted.value,
                onCheckedChange = vm::setIsCompleted
            )
        }
        bambooBrownButton(
            onClick = {
                try {
                    val event = vm.validate()
                    onAddEvent(event)
                } catch(e: Exception) {
                    vm.toggleShowValidationErrorDialog()
                }
            },
            text = "Add Task"
        )

        bambooBrownButton(onClick = { onCancel() }, text = "Cancel")
    }
}

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PandaPlannerTheme{
        val vm = AddEventViewModel(app = Application(), repo = EventsRepository(app = Application()))

        AddEvent(onAddEvent = { }, vm = vm, onCancel = {})

    }
}
