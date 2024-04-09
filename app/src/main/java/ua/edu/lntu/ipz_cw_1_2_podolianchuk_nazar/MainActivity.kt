package ua.edu.lntu.ipz_cw_1_2_podolianchuk_nazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.ipz_cw_1_2_podolianchuk_nazar.ui.theme.IPZ_CW_1_2_Podolianchuk_NazarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_1_2_Podolianchuk_NazarTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignInScreen()
                }
            }
        }
    }
}

@Composable
fun SignInScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.bodyLarge
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Result:",
            style = MaterialTheme.typography.bodyMedium
        )
        TextField(
            value = "",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = { /* Handle sign in */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Sign In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    IPZ_CW_1_2_Podolianchuk_NazarTheme {
        SignInScreen()
    }
}
