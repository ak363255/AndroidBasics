package com.example.androidinterview.permissions

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.core.os.persistableBundleOf


@Composable
fun PermissionLauncher(isPermissionGranted:MutableState<Boolean>,permissionString:String){
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(), onResult = {
           isPermissionGranted.value = true
        }
    )
    SideEffect {
        permissionLauncher.launch(permissionString)
    }
}