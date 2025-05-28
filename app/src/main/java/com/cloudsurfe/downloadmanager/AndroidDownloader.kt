package com.cloudsurfe.downloadmanager

import android.app.DownloadManager
import android.content.Context
import android.os.Environment
import androidx.core.net.toUri

class AndroidDownloader(
    private val context: Context
) : Downloader {

    private val downloadManager = context.getSystemService(DownloadManager::class.java)

    override fun downloadFile(url: String): Long {
        val request = DownloadManager.Request(url.toUri())
            .setMimeType("image/jpeg")
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setTitle("image.jpeg")
            .addRequestHeader("Authentication","Bearer <token>")
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"image.jpeg")

        return downloadManager.enqueue(request)
    }




}