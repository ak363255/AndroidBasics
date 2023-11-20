package com.example.androidinterview.workmanager

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.work.WorkInfo

@Composable
fun WorkManagerTest(workerViewModel: WorkerViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val data = workerViewModel.outPutWorkInfoItem.observeAsState()
        var workSuccess = remember {
            mutableStateOf("")
        }
        if(data.value != null && data.value!!.size > 0){
            val workInfo = data.value!![0]
            if(workInfo.state == WorkInfo.State.SUCCEEDED){
                workSuccess.value = workInfo.outputData.getString(BlurWorker.OUTPUT)?:"null"
            }else{
                workSuccess.value = "working"
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color.Red)
                .clickable {
                    workerViewModel.blur()
                }
                .align(Alignment.CenterHorizontally),
            text = "Start work", style = TextStyle(fontSize = 18.sp, color = Color.Black, textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.height(18.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            text = workSuccess.value, style = TextStyle(fontSize = 18.sp, color = Color.Black)
        )
    }
}