import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './components/user/user.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SeriesComponent } from './components/series/series.component';
import { SeriesMatchComponent } from './components/series-match/series-match.component';
import { GameComponent } from './components/game/game.component';
import { ArticleComponent } from './components/article/article.component';
import { CommentComponent } from './components/comment/comment.component';
import { ArticleService } from './services/article.service';
import { CommentService } from './services/comment.service';
import { GameStatService } from './services/game-stat.service';
import { PlayerMatchStatService } from './services/player-match-stat.service';
import { ProfileService } from './services/profile.service';
import { UserService } from './services/user.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { CreateProfileComponent } from './components/create-profile/create-profile.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from './services/auth.service';
import { HttpClientModule } from '@angular/common/http';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    NavBarComponent,
    ProfileComponent,
    SeriesComponent,
    SeriesMatchComponent,
    GameComponent,
    ArticleComponent,
    CommentComponent,
    NotFoundComponent,
    CreateProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    ArticleService,
    CommentService,
    GameStatService,
    PlayerMatchStatService,
    ProfileService,
    UserService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
