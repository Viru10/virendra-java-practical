import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewAppoitmentComponent } from './new-appoitment/new-appoitment.component';
import { ViewAppoitmentComponent } from './view-appoitment/view-appoitment.component';

const routes: Routes = [
  { path: '', redirectTo: 'view-appoitment', pathMatch: 'full'},  
  { path: 'new-appoitment', component: NewAppoitmentComponent},
  { path: 'view-appoitment', component: ViewAppoitmentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
