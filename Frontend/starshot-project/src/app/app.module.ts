import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AboutpageComponent } from './aboutpage/aboutpage.component';
import { ProductComponent } from './product/product.component';
import { ClaimComponent } from './claim/claim.component';
import { ContactComponent } from './contact/contact.component';
import { RouterModule, Routes } from '@angular/router';
import { CarouselModule, WavesModule } from 'angular-bootstrap-md'
import {MatTabsModule} from '@angular/material/tabs';
import { HttpClientModule } from '@angular/common/http';
import { ProductMusicComponent } from './product/product-music/product-music.component';
import { ProductSportsComponent } from './product/product-sports/product-sports.component';
import { ProductConferenceComponent } from './product/product-conference/product-conference.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
const appRoutes: Routes = [
  { path: 'aboutus', component: AboutpageComponent },
  { path: 'product', component: ProductComponent },
  { path: 'claim', component: ClaimComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'product/getevent/music/upcoming', component: ProductMusicComponent },
  { path: 'product/getevent/sport/upcoming', component: ProductSportsComponent },
  { path: 'product/getevent/conference/upcoming', component: ProductConferenceComponent },
  { path: '', redirectTo: '/aboutus', pathMatch: 'full' },
];
@NgModule({
  declarations: [
    AppComponent,
    AboutpageComponent,
    ProductComponent,
    ClaimComponent,
    ContactComponent,
    ProductMusicComponent,
    ProductSportsComponent,
    ProductConferenceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    RouterModule.forRoot(
      appRoutes,{enableTracing: false}
    ),
    CarouselModule,
    WavesModule,
    MatTabsModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
