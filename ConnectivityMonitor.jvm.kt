package chaintech.network.connectivitymonitor
/*
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

actual class ConnectivityMonitor private constructor() {

    private val _status = MutableStateFlow(ConnectivityStatus.DETERMINING)
    actual val status: StateFlow<ConnectivityStatus> get() = _status

    private var isConnected: Boolean = false
    private val executor = Executors.newSingleThreadScheduledExecutor()

    actual fun startMonitoring() {
        executor.scheduleAtFixedRate({
            checkConnectivity()
        }, 0, 5, TimeUnit.SECONDS) // Check every 5 seconds
    }

    actual fun stopMonitoring() {
        executor.shutdownNow()
    }

    actual fun refresh() {
        checkConnectivity()
    }

    private fun checkConnectivity() {
        val currentlyConnected = isInternetAvailable()
        if (currentlyConnected != isConnected) {
            isConnected = currentlyConnected
            val newStatus = if (isConnected) {
                ConnectivityStatus.CONNECTED
            } else {
                ConnectivityStatus.NOT_CONNECTED
            }
            _status.value = newStatus
        }
    }

    actual companion object {
        actual val instance: ConnectivityMonitor by lazy { ConnectivityMonitor() }
    }
}

fun isInternetAvailable(): Boolean {
    return try {
        val url = URL("https://www.google.com")
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        urlConnection.requestMethod = "GET"
        urlConnection.connectTimeout = 2000
        urlConnection.connect()

        val responseCode = urlConnection.responseCode
        urlConnection.disconnect()

        responseCode == 200
    } catch (e: Exception) {
        false
    }
}

/*
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.net.InetAddress
import java.net.NetworkInterface
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL

actual class ConnectivityMonitor private constructor() : PropertyChangeListener {
    private val _status = MutableStateFlow<ConnectivityStatus>(ConnectivityStatus.DETERMINING)
    actual val status: StateFlow<ConnectivityStatus> = _status.asStateFlow()
    private val pcs = PropertyChangeSupport(this)

    init {
        startMonitoring()
    }

    actual fun startMonitoring() {
        NetworkInterface.getNetworkInterfaces().toList().forEach { networkInterface ->
            println("ADD Listner: ${networkInterface.displayName}")
            pcs.addPropertyChangeListener(networkInterface.toString(), this)
        }
        updateConnectivityStatus()
    }

    actual fun stopMonitoring() {
        NetworkInterface.getNetworkInterfaces().toList().forEach { networkInterface ->
            println("Remove Listner: ${networkInterface.displayName}")
            pcs.removePropertyChangeListener(networkInterface.toString(), this)
        }
    }

    actual fun refresh() {
        updateConnectivityStatus()
    }

    private fun updateConnectivityStatus() {
        CoroutineScope(Dispatchers.IO).launch {
            val newStatus = if (hasInternetConnection()) {
                ConnectivityStatus.CONNECTED
            } else {
                ConnectivityStatus.NOT_CONNECTED
            }
            _status.value = newStatus
        }
    }

    private fun hasInternetConnection(): Boolean {
        println("api call")
        return try {
            val url = URL("https://www.google.com")
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.connectTimeout = 2000
            urlConnection.connect()

            val responseCode = urlConnection.responseCode
            urlConnection.disconnect()

            responseCode == 200
        } catch (e: Exception) {
            false
        }
    }

    override fun propertyChange(evt: PropertyChangeEvent?) {
        println("Change")
        updateConnectivityStatus()
        if (evt?.propertyName == "up" || evt?.propertyName == "down") {
            updateConnectivityStatus()
        }
    }

    actual companion object {
        private val _instance: ConnectivityMonitor by lazy { ConnectivityMonitor() }
        actual val instance: ConnectivityMonitor
            get() = _instance
    }
}
*/

*/