import {Component, OnInit} from '@angular/core';
import {SeriesMatchService} from "../../services/series-match.service";
import {Router} from "@angular/router";
import {SeriesMatch} from "../../models/series-match";
import {ArticleService} from "../../services/article.service";
import {Article} from "../../models/article";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  matches: SeriesMatch[];
  articles: Article[];

  constructor(
    private seriesMatchService: SeriesMatchService,
    private articleService: ArticleService,
    private router: Router
  ) {  }

  ngOnInit(): void {
    this.seriesMatchService.index().subscribe(
      match => {
        this.matches = match;
      },
      fail => {
        console.error(fail);
        this.router.navigateByUrl('badNews');
      }
    );
    this.articleService.getAllArticles().subscribe(
      aritcle => {
        this.articles = aritcle;
      },
      fail => {
        this.router.navigateByUrl('badnews');
      }
    );
  }
}
