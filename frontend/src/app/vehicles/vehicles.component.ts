import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { VehicleService } from './service/vehicles.service';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.scss']
})
export class VehiclesComponent implements OnInit {

  public searchVehicle: string = '';
  public showForm: boolean = false;
  public vehicles: VehicleResponse[] = [];
  public vehicleForm: FormGroup;
  private selectedVehicleId: string = null;

  constructor(
    private service: VehicleService,
    private fb: FormBuilder
  ) {
    this.vehicleForm = fb.group({
      name: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      brand: new FormControl(null, [Validators.required, Validators.maxLength(20)]),
      year: new FormControl(null, [Validators.required, Validators.min(1800), Validators.max(9999)]),
      description: new FormControl(null, [Validators.maxLength(100)])
    });
  }

  ngOnInit() {
    this.getVehicles();
  }

  public onSubmit() {
    const request = {
      name: this.vehicleForm.get("name").value,
      brand: this.vehicleForm.get("brand").value,
      year: this.vehicleForm.get("year").value,
      description: this.vehicleForm.get("description").value,
      sold: false
    };

    if (!this.selectedVehicleId) {
      this.service.create(request)
        .subscribe(response => {
          this.getVehicles();
          this.clear();
        });
    } else {
      this.service.edit(this.selectedVehicleId, request)
        .subscribe(response => {
          this.getVehicles();
          this.clear();
        });
    }
  }

  new() {
    this.showForm = true
    this.vehicleForm.get("name").setValue(null);
    this.vehicleForm.get("brand").setValue(null);
    this.vehicleForm.get("year").setValue(null);
    this.vehicleForm.get("description").setValue(null);
  }
  
  load(vehicle: VehicleResponse) {
    this.showForm = true
    this.selectedVehicleId = vehicle.id;
    this.vehicleForm.get("name").setValue(vehicle.name);
    this.vehicleForm.get("brand").setValue(vehicle.brand);
    this.vehicleForm.get("year").setValue(vehicle.year);
    this.vehicleForm.get("description").setValue(vehicle.description);
  }
  
  clear() {
    this.showForm = false
    this.selectedVehicleId = null;
    this.vehicleForm.get("name").setValue(null);
    this.vehicleForm.get("brand").setValue(null);
    this.vehicleForm.get("year").setValue(null);
    this.vehicleForm.get("description").setValue(null);
  }

  clearSearch() {
    this.searchVehicle = '';
    this.getVehicles();
  }

  getVehicles() {
    this.service.getVehicles(this.searchVehicle)
      .subscribe(reponse => this.vehicles = reponse);
  }
  
  toggleSold(vehicle: VehicleResponse) {
    this.service.updateVehicle(vehicle.id, {
      sold: !vehicle.isSold
    }).subscribe(response => {
      this.getVehicles();
    });
  }
  
  delete(vehicle: VehicleResponse) {
    this.service.deleteVehicle(vehicle.id)
      .subscribe(response => {
        this.getVehicles();
      });
  }

}
