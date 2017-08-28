import { Injectable, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable'
import 'rxjs/add/operator/map'

@Injectable()
export class DataService {

httpUrl: string = './jsondata/data.json';
   
constructor(private _http: Http){
    }

    

       getData(): Observable<any[]> {
        console.log("DataService ")
        return this._http.get(this.httpUrl)
                .map((response: Response) =>
                <any[]>response.json())
                .catch(this.handleError)

   }


    private handleError(error: Response) {
        console.error("hadle Error "+error)
        return Observable.throw(error.json().error || 'Server Error')
    }

}