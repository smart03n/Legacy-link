package com.legacylinkmvp

import android.app.Activity
import android.content.Intent
import android.net.Uri

class FileSelectionManager(private val activity: Activity) {

    private val selectedFiles = mutableListOf<Uri>()

    fun selectFiles() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        activity.startActivityForResult(intent, 1001)
    }

    fun handleActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            data?.let {
                val clipData = it.clipData
                if (clipData != null) {
                    for (i in 0 until clipData.itemCount) {
                        selectedFiles.add(clipData.getItemAt(i).uri)
                    }
                } else {
                    it.data?.let { uri -> selectedFiles.add(uri) }
                }
            }
        }
    }

    fun getSelectedFiles(): List<Uri> = selectedFiles
}
