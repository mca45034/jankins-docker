import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-transportation',
  templateUrl: './transportation.component.html',
  styleUrls: ['./transportation.component.css']
})
export class TransportationComponent extends BaseCtl {
  getKey = false;
  selected = null;
  userForm: FormGroup = null;
  uploadForm: FormGroup;

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.TRANSPORTATION, locator, route);
  }

  limitInput(event: any, maxLength: number) {
    const target = event.target;
    const value = target.value;
    if (value.length >= maxLength) {
      event.preventDefault();
      console.log('=====Rahul Kirar limit===================');
    } else if (!/^(1|2|3|4|5|6|7|8|9|0)\d{0,9}$/.test(value + event.key)) {
      event.preventDefault();
    }
  }

  
  isValidMobileInput: boolean = true;
  isValidNameInput: boolean = true;
  isValidPaymentTermInput: boolean = true;
  nameErrorMessage: string = '';
  mobileErrorMessage: string = '';
  paymentTermErrorMessage: string = '';



  validateInput(event: any, field: string) {
    const value = event.target.value;
    if (field === 'mobile') {
      this.isValidMobileInput = /^[0-9]*$/.test(value);
      this.mobileErrorMessage = this.isValidMobileInput ? '' : 'Please type numbers only';
    } else if (field === 'name') {
      this.isValidNameInput = /^[A-Za-z\s]*$/.test(value);
      this.nameErrorMessage = this.isValidNameInput ? '' : 'Please type alphabets only';
    } else if (field === 'cost') {
      const paymentTermValue = Number(value);
      this.isValidPaymentTermInput = paymentTermValue >= 0 && paymentTermValue <= 99999;
      console.log('=====Rahul Kirar range===================');
      this.paymentTermErrorMessage = this.isValidPaymentTermInput ? '' : 'Please type a number between 1 and 99999';
    }
  }


  submit() {
    var _self = this;
    console.log('in submit');
    console.log(this.form);
    console.log(this.form.data);

    this.serviceLocator.httpService.post(this.api.save, this.form.data, function (res) {
      _self.form.message = '';
      _self.form.inputerror = {}; // Clear input errors here

      if (res.success) {
        _self.form.error = false; // Set error to false on success
        _self.form.message = "Data is saved";
        _self.form.data.id = res.result.data;
        console.log(_self.form.data.id);
        console.log("----------Paras----------.");

        // Clear form data if needed
        // _self.form.data = {};

      } else {
        _self.form.error = true;
        if (res.result.inputerror) {
          _self.form.inputerror = res.result.inputerror;
        }
        _self.form.message = res.result.message;
      }
      console.log('FORM', _self.form);
    });
  }

  submit1() {
    var _self = this;
    console.log(this.form + "submit running start");
    console.log(this.form.data + "form data going to be submit");
    this.serviceLocator.httpService.post(this.api.search, this.form.data, function (res) {
      _self.form.message = '';
      _self.form.inputerror = {};
      _self.form.data.id = res.result.data;

      if (res.success) {
        _self.form.message = "Data is saved";
        _self.form.data.id = res.result.data;

        console.log(_self.form.data.id);
        console.log("--------------------.");

      } else {
        _self.form.error = true;
        _self.form.inputerror = res.result.inputerror;
        _self.form.message = res.result.message;
      }
      _self.form.data.id = res.result.data;
      console.log('FORM', _self.form);
    });
  }

  onUpload(userform: FormData) {
    this.submit();
    console.log(this.form.data.id + '---- after submit');
  }

  validatePaymentTerm() {
    const paymentTerm = this.form.data.paymentTerm;
    const paymentTermPattern = /^[a-zA-Z ]*$/; // Only allows alphabetic characters and spaces
    if (!paymentTermPattern.test(paymentTerm)) {
      this.form.inputerror.paymentTerm = 'Invalid payment term';
    } else {
      delete this.form.inputerror.paymentTerm;
    }
  }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.modeId);
    console.log(form.modeId);
    flag = flag && validator.isNotNullObject(form.description);
    console.log(form.description);
    flag = flag && validator.isNotNullObject(form.cost);
    console.log(form.cost);
    flag = flag && validator.isNotNullObject(form.date);
    console.log(form.date);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    console.log(form.id + 'populate form in shoppingcomponent');
    form.description = data.description;
    form.cost = data.cost;
    form.date = data.date;
    form.modeId = data.modeId;
  }

  validatePhone(event: KeyboardEvent) {
    const input = event.key;
    // Check if the input is a number or backspace
    if ((isNaN(Number(input)) && input !== 'Backspace') || (input === ' ')) {
      event.preventDefault();
    }
    // Limit the input to 10 characters
    if (this.form.data.phone && this.form.data.phone.length >= 10 && input !== 'Backspace') {
      event.preventDefault();
    }
  }

  validateAlphabetInput(event: KeyboardEvent) {
    const charCode = event.which || event.keyCode;
    const charStr = String.fromCharCode(charCode);

    // Regular expression to test if the character is a letter
    const letterRegex = /^[a-zA-Z\s]+$/;

    // Test if the input matches the allowed characters
    if (!letterRegex.test(charStr)) {
      event.preventDefault();
    }
  }

  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

  test() {
    // Implement your test logic here
  }
}
