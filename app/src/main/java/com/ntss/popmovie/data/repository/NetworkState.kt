package com.ntss.popmovie.data.repository

enum class Status {
    Running, Success, Failed
}

class NetworkState(val status: Status, msg: String) {
    companion object {
        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {
            LOADED = NetworkState(Status.Success, "Success")
            LOADING = NetworkState(Status.Running, "Running")
            ERROR = NetworkState(Status.Failed, "Something Went Wrong")
        }
    }

}