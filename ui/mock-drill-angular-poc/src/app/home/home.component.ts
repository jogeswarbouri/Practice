import{ Component,Input, OnInit } from '@angular/core'
import { FormGroup, FormControl, FormBuilder, AbstractControl } from '@angular/forms';
import {Http, Response} from '@angular/http'
import {DataService} from 'app/login/dataService'
import{ActivatedRoute,Params,Router,RouterModule} from '@angular/router'
import {Observable} from 'rxjs/Observable'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/do'
import 'rxjs/add/operator/catch'


@Component({

 selector: 'home',
    templateUrl: '/home.component.html'


})

export class HomeComponent implements OnInit
{
  public pageTitle: string = 'Welcome';
  public Role:string ;

    constructor(private route:ActivatedRoute, private router: Router){}
   
    ngOnInit():void {
  
     this.route.params.subscribe(value => this.Role =value['role'] )
      console.log("Roleeeeeeeeeee" + this.Role)
    
}

logout()
{
    console.log("logout successful")
   this.router.navigate( ["login"] );
}
 



}