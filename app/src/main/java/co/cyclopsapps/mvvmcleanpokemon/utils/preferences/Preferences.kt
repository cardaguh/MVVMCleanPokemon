package co.cyclopsapps.mvvmcleanpokemon.utils.preferences

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class Preferences @Inject constructor(
    private val context: Context
): IPreferences {

    private val prefs = context.applicationContext.getSharedPreferences(
        USER_PREFS_FILE_NAME,
        Context.MODE_PRIVATE)


    override var url: String
        get() = prefs.getString(URL_PREFS, "")?: ""
        set(value) {
            prefs.edit(commit = true) {
                putString(URL_PREFS, value)
            }
        }


    companion object {
        //ide de archivo prefs
        private const val USER_PREFS_FILE_NAME = "example_prefs"
        //Id de preference
        private const val URL_PREFS = "url_prefs"
    }
}