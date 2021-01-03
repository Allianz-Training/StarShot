export class Eventdata {
    constructor(
      public event_type: string,
      public event_name: string,
      public event_date: Date,
      public event_location: string,
      public package_a_price: number
    ) {}
}