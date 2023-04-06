package com.example.steamgames

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.steamgames.data.GamesDataSource
import com.example.steamgames.model.Game
import com.example.steamgames.ui.theme.SteamGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SteamGamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SteamApp()
                }
            }
        }
    }
}

@Composable
fun SteamApp(steamGames: List<Game> = GamesDataSource().getGamesList()) {
    Scaffold(
        topBar = {
            TopBar()
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(steamGames) { game ->
                GameCard(game)
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .padding(12.dp)
                .size(36.dp),
            painter = painterResource(id = R.drawable.steam_logo),
            contentDescription = stringResource(
                id = R.string.app_name
            )
        )
        Text(
            modifier = Modifier.padding(12.dp),
            text = stringResource(id = R.string.app_name),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h4
        )

    }
}

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp), elevation = 4.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    //.height(65.dp)
                    .widthIn(135.dp),

                painter = painterResource(id = game.imageDrawableResId),
                contentDescription = stringResource(
                    id = game.nameStringResId
                ),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
                Text(
                    text = stringResource(id = game.nameStringResId)
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.End),
                    text = stringResource(id = game.priceStringResId),
                    color = if (game.isOnOffer) MaterialTheme.colors.onSecondary else MaterialTheme.colors.onSurface
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    GameCard(game = GamesDataSource().getGamesList()[0])
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SteamGamesTheme {
        SteamApp()
    }
}

