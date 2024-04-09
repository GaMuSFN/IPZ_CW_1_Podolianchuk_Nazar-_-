package ua.edu.lntu.ipz_cw_1_2_podolianchuk_nazar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var isFirstLaunch by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Sign In",
            style = MaterialTheme.typography.bodyLarge
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            isError = isFirstLaunch && email.isEmpty(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            isError = isFirstLaunch && password.isEmpty(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Result: $result",
            style = MaterialTheme.typography.bodyMedium
        )
        TextField(
            value = "",
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (email.isEmpty() && password.isEmpty()) {
                    result = "Введіть пошту та пароль"
                } else if (email.isEmpty()) {
                    result = "Пошта не введена"
                } else if (password.isEmpty()) {
                    result = "Пароль не введений"
                } else {
                    result = "Успішна авторизація"
                }
            },
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
