package com.example.clinicaveterinaria

import android.content.ContentProvider
import android.database.Cursor
import android.net.Uri
import android.provider.BaseColumns

class ContentProviderClinica : ContentProvider() {
    var dbOpenHelper: BDclinicaOpenHelper? = null

