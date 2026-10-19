@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.SmartButton
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationTheme {
                App()
            }
        }
    }
}

data class ComponentItem(
    val title: String,
    val description: String,
    val route: String
)

val componentGroupMap = mapOf(
    "Display" to listOf(
        ComponentItem("Text", "Displays text", "text_detail"),
        ComponentItem("Image", "Displays an image", "image_detail")
    ),
    "Input" to listOf(
        ComponentItem("TextField", "Input field for text", "textfield_detail"),
        ComponentItem("PasswordField", "Input field for passwords", "password_detail"),
        ComponentItem("Toggle", "On/off switch", "toggle_detail"),
        ComponentItem("Slider", "Selects a value from a range", "slider_detail"),
    ),
    "Selection" to listOf(
        ComponentItem("Button", "Triggers an action when tapped", "button_detail"),
        ComponentItem("Checkbox", "Selects one or multiple options", "checkbox_detail"),
        ComponentItem("RadioButton", "Selects a single option", "radiobutton_detail"),
    ),
    "Navigation" to listOf(
        ComponentItem("NavigationView", "Navigation container with title and back button", "navigationview_detail"),
        ComponentItem("TabBar", "Switches between main sections", "tabbar_detail"),
        ComponentItem("Menu", "Shows a menu with multiple actions", "menu_detail")
    ),
    "Layout" to listOf(
        ComponentItem("Column", "Arranges elements vertically", "column_detail"),
        ComponentItem("Row", "Arranges elements horizontally", "row_detail"),
    )
   
)
@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(onNavigateToList = {
                navController.navigate("list")
            })
        }

        composable("list") {
            ListScreen(onNavigate = { route ->
                navController.navigate(route) },
                onBack = { navController.popBackStack() })
        }

        composable("text_detail") {
            TextDetailScreen(onBack = { navController.popBackStack() })
        }

        composable("image_detail") {
            ImageDetailScreen(onBack = { navController.popBackStack() })
        }

        composable("textfield_detail") {
            TextFieldDetailScreen(onBack = { navController.popBackStack() })
        }

        composable("row_detail") {
            RowDetailScreen(onBack = { navController.popBackStack() })
        }

        composable("password_detail") {
            PasswordFieldDetailScreen(onBack = { navController.popBackStack() })
        }
        composable("toggle_detail") {
            ToggleScreen(onBack = { navController.popBackStack() })
        }
        composable("slider_detail") {
            SliderScreen(onBack = { navController.popBackStack() })
        }
        composable("button_detail") {
            ButtonScreen(onBack = { navController.popBackStack() })
        }
        composable("checkbox_detail") {
            CheckboxScreen(onBack = { navController.popBackStack() })
        }
        composable("radiobutton_detail") {
            RadioButtonScreen(onBack = { navController.popBackStack() })
        }
        composable("navigationview_detail") {
            NavigationViewScreen(onBack = { navController.popBackStack() })
        }
         composable("tabbar_detail") {
            TabBarScreen(onBack = { navController.popBackStack() })
        }
        composable("menu_detail") {
            MenuScreen(onBack = { navController.popBackStack() })
        }
        composable("column_detail") {
            ColumnScreen(onBack = { navController.popBackStack() })
        }
        composable("row_detail") {
            RowScreen(onBack = { navController.popBackStack() })
        }

    }
}

@Composable
fun HomeScreen(onNavigateToList: () -> Unit){
    val image = painterResource(R.drawable.img)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = "logo",
            modifier = Modifier.size(300.dp)
        )
        Text(
            text = "Jetpack Compose",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Jetpack Compose is a modern UI toolkit for"
        )
        Text(
            text = "building native Android applications using"
        )
        Text(
            text = "a declarative programming appoach"
        )
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {onNavigateToList()},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF538CDA)),
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
            ) {
            Text(text="I'm ready")

        }
    }
}


@Composable
fun ListScreen(onNavigate: (String) -> Unit, onBack: () -> Unit, showTopBar: Boolean = true) {
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "UI Components List",
                            color = Color(0xFF2052DE),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for ((sectionTitle, items) in componentGroupMap) {

                Text(
                    text = sectionTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                )

                for (item in items) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onNavigate(item.route) },
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF7DA5E1)
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = item.title,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = item.description,
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun TextDetailScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "Text Detail",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            val annotatedString = buildAnnotatedString {
                append("The ")

                withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("quick")
                }

                withStyle(
                    SpanStyle(
                        color = Color(0xFFB45309),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(" Brown\n")
                }

                append("fox ")

                withStyle(SpanStyle(letterSpacing = 4.sp)) {
                    append("jumps ")
                }

                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("over\n")
                }

                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("the ")
                }

                withStyle(SpanStyle(fontStyle = FontStyle.Italic)) {
                    append("lazy")
                }

                append(" dog.")
            }

            Text(
                text = annotatedString,
                fontSize = 22.sp,
                lineHeight = 36.sp
            )
        }
    }
}
@Composable
fun ImageDetailScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    val image = painterResource(R.drawable.img_1)
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "Images",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = image,
                contentDescription = "school",
            )

            Text(
                text = "In app",
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}
@Composable
fun TextFieldDetailScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    var inputText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "TextField",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                placeholder = { Text("Thông tin nhập", color = Color.Gray) },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = if (inputText.isEmpty()) "Tự động cập nhật dữ liệu theo textfield" else inputText,
                color = if (inputText.isEmpty()) Color(0xFFDC2626) else Color.Black,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun RowDetailScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "Row Layout",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(4) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF93C5FD))
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF3B82F6))
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF93C5FD))
                    )
                }
            }
        }
    }
}

@Composable
fun PasswordFieldDetailScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "PassWordField",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {Text("PassWord")},
                placeholder = { Text("Thông tin nhập", color = Color.Gray) },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }

                    val description = if (passwordVisible) "Ẩn mật khẩu" else "Hiện mật khẩu"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = description)
                    }
                }
            )
        }
    }
}

@Composable
fun ToggleScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    var isCheck by remember { mutableStateOf(false) }
    val backgroundColor = if (isCheck) Color(0xFF000000) else Color(0xFFF5F5F5)

    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "Toggle",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundColor)                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = if (isCheck) "On" else "Off"
            )

            Switch(
                checked = isCheck,
                onCheckedChange = { isCheck = it}
            )
        }
    }
}


@Composable
fun SliderScreen(onBack: () -> Unit) {
    var sliderValue by remember { mutableStateOf(0f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Slider",
                        color = Color(0xFF1D4ED8),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    ) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color(0xFF1D4ED8)
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Giá trị: ${sliderValue.toInt()}"
            )

            Slider(
                value = sliderValue,
                onValueChange = {sliderValue= it },
                valueRange = 0f..100f,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}
@Composable
fun ButtonScreen(onBack: () -> Unit, showTopBar: Boolean = true) {

    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "Button",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Button(onClick = {""}){
                Text(text = "Here")
            }
            Text(text = "Button")
            Spacer(modifier = Modifier.height(8.dp))
            ElevatedButton(onClick = {""}) {
                Text(text = "Here")
            }
            Text(text = "ElevatedButton")
            Spacer(modifier = Modifier.height(8.dp))
            FilledIconButton(onClick = {""}) {
                Text(text = "Here")
            }
            Text(text = "FilledTonalButton")
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = {""}) {
                Text(text = "Here")
            }
            Text(text = "OutlinedButton")
            Spacer(modifier = Modifier.height(8.dp))
            TextButton(onClick = {""}) {
                Text(text = "Here")
            }
            Text(text = "TextButton")
        }
    }
}
@Composable
fun CheckboxScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    var isCheck1 by remember { mutableStateOf(false) }
    var isCheck2 by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "Checkbox",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isCheck1,
                    onCheckedChange = { isCheck1 = it }
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Toi dong tinh"
                )
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = isCheck2,
                    onCheckedChange = { isCheck2 = it }
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Toi khong dong tinh"
                )
            }
        }
    }
}
@Composable
fun RadioButtonScreen(onBack: () -> Unit, showTopBar: Boolean = true) {
    val options = listOf("Toi dong tinh", "Toi khong dong tinh", "Ban dong tinh", "Ban khong dong tinh")
    var selectedOption by remember {mutableStateOf(options[0])}
    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "RadioButton",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            options.forEach { option ->
                Row( modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedOption = option }
                    .padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (option == selectedOption),
                        onClick = { selectedOption = option },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = MaterialTheme.colorScheme.primary,
                            unselectedColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = option
                    )
                }

            }
        }
    }
}

@Composable
fun NavigationViewScreen(onBack: () -> Unit, showTopBar: Boolean = true) {

    Scaffold(
        topBar = {
            if(showTopBar) {
                TopAppBar(
                    title = {
                        Text(
                            "NavigationView",
                            color = Color(0xFF1D4ED8),
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
            }
        }
    ){padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Navigation container with title and back button")
        }
    }
}

@Composable
fun TabBarScreen(onBack: () -> Unit) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf(
        Pair("List", Icons.Default.List),
        Pair("Text", Icons.Default.Textsms),
        Pair("Image", Icons.Default.Image),
        Pair("TextField", Icons.Default.TextFields),
        Pair("PassWordField", Icons.Default.Password),
        Pair("Toggle", Icons.Default.ToggleOn),
        Pair("Button", Icons.Default.SmartButton),
        Pair("RadioButton", Icons.Default.RadioButtonChecked),
        Pair("CheckBox", Icons.Default.CheckBox),
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("TabBar",
                        color = Color(0xFF1D4ED8),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    ) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Back",
                            tint = Color(0xFF1D4ED8)
                        )
                    }
                }
            )
        },
        bottomBar = {
            ScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                tabs.forEachIndexed { index, tab ->
                    val isSelected = selectedTabIndex == index

                    Tab(
                        selected = isSelected,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = tab.first,
                                style = if (isSelected) MaterialTheme.typography.labelLarge else MaterialTheme.typography.bodyMedium
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = tab.second,
                                contentDescription = tab.first
                            )
                        }
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            when (selectedTabIndex) {
                0 -> ListScreen(onNavigate = {}, onBack = {}, showTopBar = false)
                1 -> TextDetailScreen(onBack = {}, showTopBar = false)
                2 -> ImageDetailScreen(onBack = {}, showTopBar = false)
                3 -> TextFieldDetailScreen(onBack = {}, showTopBar = false)
                4 -> PasswordFieldDetailScreen(onBack = {}, showTopBar = false)
                5 -> ToggleScreen(onBack = {}, showTopBar = false)
                6 -> ButtonScreen(onBack = {}, showTopBar = false)
                7 -> RadioButtonScreen(onBack = {}, showTopBar = false)
                8 -> CheckboxScreen(onBack = {}, showTopBar = false)

            }
        }
    }
}

@Composable
fun MenuScreen(onBack: () -> Unit) {
    var expanded by remember{mutableStateOf(false)}
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "RadioButton",
                        color = Color(0xFF1D4ED8),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Bấm vào")
            Box(
                modifier = Modifier.wrapContentSize(Alignment.TopEnd)
            ){
                IconButton(onClick = {expanded = true}) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Menu"
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = {expanded = false}
                ) {
                    DropdownMenuItem(
                        text = {Text("Chỉnh sửa")},
                        onClick = {
                            expanded = false
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Edit, contentDescription = null)
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Share")},
                        onClick = {
                            expanded = false
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Share, contentDescription = null)
                        }
                    )
                    DropdownMenuItem(
                        text = {Text("Xóa")},
                        onClick = {
                            expanded = false
                        },
                        leadingIcon = {
                            Icon(Icons.Default.Remove, contentDescription = null)
                        }
                    )
                }

            }

        }
    }
}

@Composable
fun ColumnScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Column",
                        color = Color(0xFF1D4ED8),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Column {
                Row {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF1D4ED8))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                }
                Row {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF1D4ED8))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                }
                Row {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF1D4ED8))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                }

            }

        }
    }
}
@Composable
fun RowScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Row",
                        color = Color(0xFF1D4ED8),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowLeft,
                                contentDescription = "Back",
                                tint = Color(0xFF1D4ED8)
                            )
                        }
                    }
                )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Row {
                Column {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF1D4ED8))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                }
                Column {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF1D4ED8))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                }
                Column {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF1D4ED8))
                    )
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(100.dp)
                            .clip(shape = RoundedCornerShape(16.dp))
                            .background(Color(0xFF9EB4F5))
                    )
                }
            }

        }
    }
}

