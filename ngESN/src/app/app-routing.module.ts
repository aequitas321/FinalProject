import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {ArticleComponent} from './components/article/article.component';
import {ProfileComponent} from './components/profile/profile.component';
import {GameComponent} from './components/game/game.component';
import {RegisterComponent} from './components/register/register.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {SeriesMatchComponent} from './components/series-match/series-match.component';
import {PlayerComponent} from "./components/player/player.component";


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'article/:id', component: ArticleComponent},
  {path: 'profile', component: ProfileComponent, runGuardsAndResolvers: 'always'},
  {path: 'game', component: GameComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'match', component: SeriesMatchComponent},
  {path: 'match/:id', component: SeriesMatchComponent},
  {path: 'games/:id', component: GameComponent, runGuardsAndResolvers: 'always'},
  {path: 'player/:id', component: PlayerComponent},
  {path: '', component: HomeComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
