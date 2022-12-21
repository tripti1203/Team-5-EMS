export class Bill {
    id!:number;
    dateTime!:string
    month!:number
    year!:number
    oldReading!:number
    newReading!:number
    billedUnits!:number
    totalAmount!:number
    consumer?:{
        "id"?:number
        
    }
    connections?:{
        "id"?:number
    }
    connectionType?:{
        "id"?:number
    }
    

}