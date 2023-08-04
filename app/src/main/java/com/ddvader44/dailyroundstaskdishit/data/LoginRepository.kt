package com.ddvader44.dailyroundstaskdishit.data

import com.ddvader44.dailyroundstaskdishit.data.model.LoggedInUser
/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        // handle login
        //should encrypt for more security when storing locally
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

//    fun readJSONFromAsset(): String? {
//        var json: String? = null
//        try {
//            val  inputStream: InputStream = assets.open("countries.json")
//            json = inputStream.bufferedReader().use{it.readText()}
//        } catch (ex: Exception) {
//            ex.printStackTrace()
//            return null
//        }
//        return json
//    }

    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }
}