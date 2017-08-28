import{ Component,Input, OnInit } from '@angular/core'
import { FormGroup, FormControl, FormBuilder, AbstractControl } from '@angular/forms';
import {Http, Response,RequestOptions, Headers} from '@angular/http'
import { RouterModule,Router,ActivatedRoute } from '@angular/router';
import {DataService} from './dataService'
import {Observable} from 'rxjs/Observable'
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/do'
import 'rxjs/add/operator/catch'
import 'rxjs/add/observable/throw'

@Component({
    selector: 'login',
    templateUrl: '/login.component.html'

})

export class LoginComponent implements OnInit{
    LoginForm : FormGroup
    formElements:any [];
    Role:string;
    username:string
    password:string
    form : FormData
    errormsg:string;
    // roleerrormsg:string
    successMsg : string;

    constructor(private fb: FormBuilder,private dataservice :DataService, private router: Router,private http :Http ) {}
     
     ngOnInit():void {
    
      this.LoginForm = this.fb.group({})
      this.dataservice.getData()
       .subscribe(data =>
       { this.createForm(data),
          error => console.log("Error: "+error)})

     }

     createForm(item:any)
     {
         this.formElements=item
         const group=this.fb.group({})
         this.formElements.forEach(
             formElement =>{group.addControl(formElement.name,new FormControl(formElement.value)),
                           console.log("formElement" + formElement.name + formElement.value)}
         )
           this.LoginForm = group
     }

     submit(form)
     {
         this.successMsg = ""
         this.errormsg = ""
         console.log("saved successfully" )
          const userName = this.LoginForm.get("username").value
          const password = this.LoginForm.get("password").value
          const role =     this.LoginForm.get("role").value
          this.Role=role
          this.username = userName
          this.password=password
          this.form = form;
          console.log("roleeeeeee" + this.Role)


          let headers = new Headers({ 
          'Authorization': 'Basic ' + btoa(this.username + ':' + this.password),
          'X-Requested-With': 'XMLHttpRequest' // to suppress 401 browser popup
    });

           let options = new RequestOptions({ 
                headers: headers 
           });

   
         this.http.post('/api'+'/authenticate?roleName='+this.Role, {}, options).
            map((res:any) => {
                console.log(res._body);
                this.successMsg = res._body;
                console.log(this.successMsg)
                return res
            }).
            catch(this.handleError).
            subscribe(data =>  { 
                    if(this.successMsg == "success"){
                        console.log("2222:::"+data)
                        this.router.navigate( ["home",this.Role] );
                        }else{  
                            this.errormsg = "You are not authorize for selected role";
                            console.log("--->"+this.errormsg)
                            this.LoginForm.reset()
                            // this.router.navigate( ["login"] );
                        }
                },
                error =>{ 
                    console.log("Error1111--->: "+error);
                     this.LoginForm.reset()
                 if (error) {
                    console.log(this.form)
                   this.errormsg= "Invalid Credentials"
                   this.router.navigate( ["login"] );
                 }
            });
    

}
    

     reset(form)
     {
         this.errormsg ="";
        //  this.roleerrormsg="";
         console.log("Reset successfully")
         form.reset;
     }

     
    private handleError(error: Response){
        console.error("1---->"+error.statusText)
        return Observable.throw(error)
    }


}