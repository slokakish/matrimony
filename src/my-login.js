import { PolymerElement, html } from '@polymer/polymer/polymer-element.js';
import '@polymer/paper-card/paper-card.js';
import '@polymer/paper-button/paper-button.js';
import '@polymer/paper-input/paper-input.js';
import '@polymer/paper-dropdown-menu/paper-dropdown-menu.js';
import '@polymer/paper-item/paper-item.js';
import '@polymer/paper-listbox/paper-listbox.js';
import '@polymer/iron-form/iron-form.js';
import '@polymer/paper-toast/paper-toast.js';
import '@vaadin/vaadin-grid/vaadin-grid.js';
// Import template repeater
import '@polymer/polymer/lib/elements/dom-repeat.js';


// Define the element's API using an ES2015 class
class LoginElement extends PolymerElement {

  // Define optional shadow DOM template
  static get template() {
    return html`
      <style>
        /* CSS rules for your element */
        paper-card{
          margin:4%;
          margin-left:6%;
          width:90%;
        }
        paper-card:hover{
         border-bottom: 3px solid #ff6200; 
        
         cursor:pointer;
        
        }
.customizedcss{
  background-color:rgba(0,0,0,0.8);
  color:#fff;

}
   
.customizedDangercss{
  background-color:red;
  color:rgba(255, 98, 0, 0.66);
  color:#fff;

}
  #actions{
    margin-top: 7%;
    margin-left: 27%;
    width: 30%;
    border:8px solid beige
  }     
  #alertdialog{
    color:#ff6200!important;
    min-width: 31%;
    margin-top:-28%;
    position: fixed;
    border: 6px solid beige;
  }
  #createdAccountDetailsDialogId{
    color:#ff6200!important;
    border: 6px solid beige;

  }
  .headerStyle{
    background: #d9475c;
    margin:1%;
    padding:1%;
    color:white;
  }
      </style>

        <!-- shadow DOM for your element -->
   
 
  <!-- data bindings in shadow DOM -->
  

<paper-card >
<!--alert-dialog-->

<paper-dialog id="alertdialog">
  <h2>[[alertMsg]]</h2>
  <paper-button class="custom indigo customizedDangercss" style="float:right" dialog-confirm autofocus>OK</paper-button>
 </paper-dialog>
  <div class="card-content" style="background-color:beige">
  <paper-tabs selected="0">
        <paper-tab id="login"  data-item$="login" on-click="_switchBetweenLoginAndCreate">Login</paper-tab>
        <paper-tab id="create" data-item$="create" on-click="_switchBetweenLoginAndCreate">Create Profile</paper-tab>
          
</paper-tabs>
  </div>

  <!--SignIn  Form End-->
  <template is="dom-if" if="{{showLoginForm}}">
          <div class="card-actions"  style="margin:20px;border:5px solid beige; background-color:bisque">
          <p class="headerStyle">
          Login Member,
        <small>Meet over 10 lakh profiles</small>
              <div class="horizontal justified">
            <iron-form id="loginForm">
              <form>
                            <paper-input  value="{{loginName}}" always-float-label label="User" error-message="Enter First Name" auto-validate required></paper-input>
                            <paper-input type="password" value="{{password}}" always-float-label label="password" error-message="Enter First Name" auto-validate required></paper-input>
                            <paper-button class="custom indigo customizedcss"  
                            on-click="_loginAuthication">Login</paper-button>
                            <paper-button toggles class="custom indigo customizedDangercss" class="green" on-click="_resetForm">Reset</paper-button>
                </form>
                
              </iron-form> 
        </div>
    </template>
    <!--SignIn  Form End-->


    <!--Account Creation Form start-->
    <template is="dom-if" if="{{showSignUpForm}}">
    <div class="card-actions"  style="margin:20px;border:5px solid beige; background-color:bisque">
            <p class="headerStyle">
            REGISTER FREE
          <small>Meet over 10 lakh profiles</small>
            
            </p>
            <div class="horizontal justified">
          <iron-form id="ceateAccountForm">
            <form>
            <!--{
              "age": 0,
              "caste": "string",
              "dob": "2019-06-07T07:28:18.631Z",---
              "emailId": "string",
              "firstName": "string",
              "gender": "string",---
              "lastName": "string",
              "mobile": 0,
              "openToMany": "string",---
              "religionPreference": "string",
              "salary": 0
             }-->
                              <paper-input type="number" value="{{age}}" always-float-label label="Age" error-message="Enter First Name" auto-validate required></paper-input>
                              <paper-input  value="{{caste}}" always-float-label label="Caste" error-message="Enter Caste Name" auto-validate required></paper-input>
                              <paper-input type="date" value="{{dob}}" always-float-label label="AccountNumber" error-message="Enter First Name" auto-validate required></paper-input>
                            
                              <paper-input type="emailId" value="{{emailId}}" always-float-label label="EmailId" error-message="Enter Email" auto-validate required></paper-input>
                            
                              <paper-input  value="{{firstName}}" always-float-label label="FirstName" error-message="Enter First Name" auto-validate required></paper-input>
                            
                              <paper-input  value="{{lastName}}" always-float-label label="LastName" error-message="Enter LastName " auto-validate required></paper-input>
                              <paper-input type="number" value="{{mobile}}" always-float-label label="Contact Number" error-message="Enter First Name" auto-validate required></paper-input>
                             
                              <paper-input value="{{openToMany}}" always-float-label label="OpenToMany" error-message="Enter" auto-validate required></paper-input>
                             
                             
                             <!--
                              <paper-input  type="number" value="{{contactNumber}}" always-float-label label="ContactNumber" error-message="Enter First Name" auto-validate required></paper-input>
                             
                             --> <paper-input   value="{{religionPreference}}" always-float-label label="ReligionPreference" error-message="Enter First Name" auto-validate required></paper-input>
                              
                              
                              <paper-input   value="{{salary}}" always-float-label label="salary" error-message="Salary" auto-validate required></paper-input>
                             
                          <paper-button class="custom indigo customizedcss"  
                          on-click="_submitCreateAccountForm">Create Profile</paper-button>
                  
                          <paper-button toggles class="custom indigo customizedDangercss" class="green" on-click="_resetForm">Reset</paper-button>
              </form>
              
                </iron-form> 
          </iron-form> 
      </div>
    </template>
    <!--Account Creation Form End-->

  </div>
                <iron-ajax
                      id="ajaxSinUp"
                      on-response="_signUpHandler"
                      on-error ="_errorHandler"
                      debounce-duration="300">
              </iron-ajax>  


              <iron-ajax
                id="signInAjax"
                on-response="_signInHandler"
                on-error ="_errorHandler"
                debounce-duration="300">
            </iron-ajax> 
<!--Noraml Alert dialog-->
    <paper-dialog id="alertdialog">
            <h2>[[alertMsg]]</h2>
            <paper-button class="custom indigo customizedDangercss" style="float:right" dialog-confirm autofocus>OK</paper-button>
  </paper-dialog>
  
  <!--Details  Dialog Start-->
  <!--{profileId, firstName,lastName,age,gender,salary,caste,religionPreference,openToMany,mobile,emailId,dob}-->
<paper-dialog id="createdAccountDetailsDialogId">
                <div><h2 style="color:rgba(255, 98, 0, 0.66);">Created Profile Details:</h2></div>
                <div>ProfileId<span>: [[createdAccountDetails.loginId]]</span></div>
                <div>FirstName<span>: [[createdAccountDetails.loginName]]</span></div>
                <div>LastName<span>: [[createdAccountDetails.password]]</span></div>
               <!-- <div>Age<span>: [[createdAccountDetails.age]]</span></div>
                <div>Salary<span>: [[createdAccountDetails.salary]]</span></div>
                <div>Caste<span>: [[createdAccountDetails.caste]]</span></div>
                <div>ReligionPreference<span>: [[createdAccountDetails.religionPreference]]</span></div>
                <div>Contact Number<span>: [[createdAccountDetails.mobile]]</span></div>
                <div>EmailId<span>: [[createdAccountDetails.emailId]]</span></div>
                <div>Contact Number<span>: [[createdAccountDetails.mobile]]</span></div>
                <div>Date Of Birth<span>: [[createdAccountDetails.dob]]</span></div>-->
            <div class="buttons">
                  <paper-button dialog-dismiss>OK</paper-button>
                 
                <!-- <paper-button dialog-confirm autofocus>Accept</paper-button>-->
                </div>
</paper-dialog>

<!--Details  Dialog End-->
</paper-card>
    `;
  }

  // Declare properties for the element's public API
  static get properties() {
    return {
      creditStatus:{
        type:String,
        value :"Not Approved"
      },
      appliactionStatus:{
        type:String,
        value:"New"
      },
      greeting: {
        type: String
      },
      baseUrl:
      {
        type: String,
        value: "http://10.117.189.210:8090/app"
      },
      subUrl:
      {
        type: String,
        value: `/login`
      },
      alertMsg: {
        type: String,
        value: ""
      },
      showLoginForm:{
        type:Boolean,
        value:true
      },
      showSignUpForm:{
        type:Boolean,
        value:false
      },
      createdAccountDetails:{
        type:Object, 
        value:{}
      }
    }
  }

  constructor() {
    super();
    
  }
  connectedCallback(){
    super.connectedCallback();
   //this loggedInUsrDetails= JSON.parse(sessionStorage.getItem("userDetails"));
    //sessionStorage.setItem("userDetails", JSON.stringify());

  }
  _switchBetweenLoginAndCreate(event){
    console.log('_switchBetweenLoginAndCreate', event.target.dataset.item$);
    let falg = event.target.dataset.item$;
    if(falg=='login'){
      this.showLoginForm = true;
      this.showSignUpForm = false;
      //this.$.signInFormDialog.open();
    }else{
      this.showLoginForm = false;
      this.showSignUpForm = true;
     // this.$.signUpFormDialog.open();
      
    }
  }
  _loginAuthication() {
   
   // const isValidate = this.$.loginForm.validate();
   // console.log(this.$.loginForm.validate())
    if (this.loginName) {
      const jsonBody = {
        loginName: this.loginName,
        password: this.password,
      }//{loginName,password}
      let ajaxRef = this.$.signInAjax;
      ajaxRef.method = "post";
      ajaxRef.url = `${this.baseUrl}/login`,
      ajaxRef.body = jsonBody;
      ajaxRef.contentType = "application/json"
      ajaxRef.generateRequest();
    }else{
       //alertdialog,alertMsg
       this.alertMsg ="Please Enter User Credetails"
       this.$.alertdialog.open();

    }
  }

  _signInHandler(event){
    const response = event.detail.response;
    if(response.actionMessage== "success"){
          // Store
          const response = event.detail.response;
          sessionStorage.setItem("userDetails", JSON.stringify(response));
          localStorage.loggedInId= response.profile.profileId;
          localStorage.profileName =response.profile.firstName;
          alert(localStorage.loggedInId);
          console.log( localStorage.loggedInId);
          window.history.pushState({}, null, '/dashboard');
          window.dispatchEvent(new CustomEvent("location-changed"));
    }else{
      //alertdialog,alertMsg
      this.alertMsg ="User is not existing"
      this.$.alertdialog.open();

    }
    

  }
  _signUpHandler(event){
    const response = event.detail.response;
    if(response){
     // createdAccountDetailsDialogId, createdAccountDetails
      this.createdAccountDetails = response;
      this.$.createdAccountDetailsDialogId.open();
    }else{
      //alertdialog,alertMsg
      this.alertMsg ="Failed To Create Profile"
      this.$.alertdialog.open();

    }
  }
  _errorHandler(){
    this.alertMsg ="Error, Check Server"
    this.$.alertdialog.open();
  }

  _resetForm() {
    this.$.loginForm.reset();
  }
  _responseHandler(event) {
    const response = event.detail.response;
  }

  _handleError() {
    alert('_handleError');
  }

  _submitCreateAccountForm() {
  //  const isValidate = this.$.ceateAccountForm.validate();
   // console.log(this.$.ceateAccountForm.validate())
   
   //window.history.pushState({}, null, '/list');
  // window.dispatchEvent(new CustomEvent("location-changed"));
   /*
  "age": 0,
  "caste": "string",
  "dob": "2019-06-07T07:28:18.631Z",
  "emailId": "string",
  "firstName": "string",
  "gender": "string",
  "lastName": "string",
  "mobile": 0,
  "openToMany": "string",
  "religionPreference": "string",
  "salary": 0

   */
   //{firstName,lastName,accountNumber,pancard,emailId,contactNumber}
    if (true) {
      const jsonBody = {
        ageDto: this.age,
        casteDto: this.caste,
        dobDto: this.dob,
        emailIdDto: this.emailId,
        firstNameDto:this.firstName,
        genderDto:this.gender,
        mobileDto: this.mobile,
        openToManyDto:"yes",//this.openToMany,
        genderDto:"male",
        religionPreferenceDto: this.religionPreference,
       // openToMany:this.openToMany,
        salaryDto:this.salary,
        lastNameDto:this.lastName
      }
      console.log(jsonBody);
      let ajaxRef = this.$.ajaxSinUp;
      ajaxRef.method = 'post';
      ajaxRef.url = `${this.baseUrl}/createProfile`,
      ajaxRef.body = jsonBody;
      ajaxRef.contentType = "application/json"
      ajaxRef.generateRequest();
    }
  }

  


}

// Register the x-custom element with the browser
customElements.define('login-element', LoginElement);