package com.cloudsurfe.downloadmanager

interface Downloader {
    fun downloadFile(url : String) : Long

}