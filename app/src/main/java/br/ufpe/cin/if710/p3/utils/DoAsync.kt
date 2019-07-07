package br.ufpe.cin.if710.p3.utils

import android.os.AsyncTask

class DoAsync (val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        handler()
        return null
    }
}