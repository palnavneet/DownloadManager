package com.cloudsurfe.downloadmanager

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class DownloadCompletedReceiver : BroadcastReceiver(){

    private lateinit var downloadManager: DownloadManager

    override fun onReceive(context: Context?, intent: Intent?) {
        downloadManager = context?.getSystemService(DownloadManager::class.java)!!
        if (intent?.action == "android.intent.action.DOWNLOAD_COMPLETED"){
            val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1L)
//            val query = DownloadManager.Query()
            if (id != -1L){
                println("Download with ID $id finished!")
            }
        }
    }

}