package edu.towson.cosc435.maddox.pandaplanner.ui.screens.addEvent

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.towson.cosc435.maddox.pandaplanner.model.Event
import edu.towson.cosc435.maddox.pandaplanner.ui.components.SmallHeader
import edu.towson.cosc435.maddox.pandaplanner.ui.components.genericText
import edu.towson.cosc435.maddox.pandaplanner.ui.theme.PandaPlannerTheme
import java.lang.Exception

@ExperimentalComposeUiApi
@Composable
fun AddEvent(
    vm: AddEventViewModel = viewModel(),
    onAddEvent: (Event) -> Unit
) {
    val locContext = LocalContext.current
    val (startDateTf, endDateTf, eventNameTf, eventDetailsTf, priorityTf) = remember { FocusRequester.createRefs() }
    val keyboardController = LocalSoftwareKeyboardController.current
    LaunchedEffect(true) {
        startDateTf.requestFocus()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        SmallHeader(Text = "Add a new event")
        OutlinedTextField(
            value = vm.eventDetails.value,
            onValueChange = vm::setEventDetails,
            placeholder = {
                genericText("Start Date")
            },
            label = {
                genericText("Start Date")
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
                genericText("End Date")
            },
            singleLine = true,
            label = {
                genericText("End Date")
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
                genericText("Event Name")
            },
            label = {
                genericText("Event Name")
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
                genericText("Event Details")
            },
            label = {
                genericText("Event Details")
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
        OutlinedTextField(
            value = vm.priority.value,
            onValueChange = vm::setPriority,
            placeholder = {
                Text("Priority")
            },
            singleLine = true,
            label = {
                Text("Priority")
            },
            modifier = Modifier
                .padding(16.dp)
                .focusRequester(priorityTf),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = { keyboardController?.hide() }
            )
        )
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
        Button(
            onClick = {
                try {
                    val event = vm.validate()
                    onAddEvent(event)
                } catch(e: Exception) {
                    //Toast.makeText(locContext, e.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Add Task")
        }
    }
}

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PandaPlannerTheme() {
        val vm = AddEventViewModel()
        AddEvent(vm = vm, onAddEvent = {})
    }
}
