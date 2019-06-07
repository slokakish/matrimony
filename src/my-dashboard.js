import { PolymerElement, html } from '@polymer/polymer/polymer-element.js';
import '@polymer/paper-card/paper-card.js';
import '@vaadin/vaadin-grid/vaadin-grid.js';
import '@polymer/paper-button/paper-button.js';
import '@polymer/paper-input/paper-input.js';
import '@polymer/paper-dropdown-menu/paper-dropdown-menu.js';
import '@polymer/paper-item/paper-item.js';
import '@polymer/paper-listbox/paper-listbox.js';
import '@polymer/iron-form/iron-form.js';
import '@polymer/paper-toast/paper-toast.js';
import '@polymer/iron-ajax/iron-ajax.js';
//import '@vaadin/vaadin-grid/vaadin-grid.js';
// Import template repeater
import '@polymer/polymer/lib/elements/dom-repeat.js';

import '@polymer/iron-collapse/iron-collapse.js';
import '@polymer/paper-badge/paper-badge.js';


// Define the element's API using an ES2015 class
class DashboardElement extends PolymerElement {

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
  #createdAccountDetailsDialog{
    color:#ff6200!important;
    border: 6px solid beige;

  }
  iron-collapse {
    border: 1px solid #dedede;
    border-top: none;
    border-bottom-left-radius: 5px;
    border-bottom-right-radius: 5px;
    @apply --shadow-elevation-2dp;
  }
  paper-item{
    background-color:cadetblue;
    color:white;
    height:12px;
    border-bottom: 2px solid red;
  } 
  .bkg{
    background-color:#d9475c;
    color:white;
  }
</style>

      
<paper-card >
<!--alert-dialog-->

<paper-dialog id="alertdialog">
  <h2>[[alertMsg]]</h2>
  <paper-button class="custom indigo customizedDangercss" style="float:right" dialog-confirm autofocus>OK</paper-button>
 </paper-dialog>
  <div class="card-content" style="background-color:beige">

  </div>
 
          <div class="card-actions"  style="margin:20px;border:5px solid beige; background-color:bisque">
              <p>Profiles:</p>
              <paper-tabs selected="0">
                       <paper-tab id="productGroupName1"  data-item$="profile" on-click="_switchBetweenLoginAndCreate">
                Profiles
              
               </paper-tab>
              <paper-tab id="productGroupName2" data-item$="interested" on-click="_switchBetweenLoginAndCreate">
                       Interested
              </paper-tab>
              <paper-tab id="productGroupName3" data-item$="accepted" on-click="_switchBetweenLoginAndCreate">
                     Accepted
              
              </paper-tab>
              <paper-tab id="productGroupName3" data-item$="rejected" on-click="_switchBetweenLoginAndCreate">
                      Rejected
              
              </paper-tab>
                
      </paper-tabs>
            
    

    


            
         
    <!--Account Creation Form End-->

  </div>


 
</div>
             
           
<!--Noraml Alert dialog-->
    <paper-dialog id="alertdialog">
            <h2>[[alertMsg]]</h2>
            <paper-button class="custom indigo customizedDangercss" style="float:right" dialog-confirm autofocus>OK</paper-button>
  </paper-dialog>

  <!--Details  Dialog Start-->
<paper-dialog id="createdAccountDetailsDialog">
                <div><h2 style="color:rgba(255, 98, 0, 0.66);">Created Account Details:</h2></div>
                <div>AccountId<span>: [[createdAccountDetails.account.accountId]]</span></div>
                <div>LoggedIn User Id<span>: [[createdAccountDetails.loginId]]</span></div>
                <div>Password has been sent to your registered email id. Please Check</span></div>
            <div class="buttons">
                  <paper-button dialog-dismiss>OK</paper-button>
                <!-- <paper-button dialog-confirm autofocus>Accept</paper-button>-->
                </div>
</paper-dialog>

<!--Details  Dialog End-->


<iron-ajax
      id="profileAjax"
      on-response="_profileHandler"
      on-error ="_errorHandler"
      debounce-duration="300">
</iron-ajax>  

<iron-ajax
        id="interestedAjax"
        on-response="_interestedHanler" 
        on-error ="_errorHandler"
        debounce-duration="300">
</iron-ajax>  

<iron-ajax
    id="acceptedAjax"
    on-response="_acceptedAjaxHanler"
    on-error ="_errorHandler"
    debounce-duration="300">
</iron-ajax>  


<iron-ajax
        id="rejectedAjax"
        on-response="_rejectedHandler"
        on-error ="_errorHandler"
        debounce-duration="300">
        </iron-ajax> 
       
        <iron-ajax
        id="interestSendAjax"
        on-response="_interestSendHandler"
        on-error ="_errorHandler"
        debounce-duration="300">
        </iron-ajax> 


        
</paper-card>
<!--Profile List-->
<template is="dom-if" if="{{profileListFlag}}">
   <div class="card-actions"  style="margin:20px;border:1px solid gray; background-color:ivory;padding:1%">
           <p>Profiles:</p>
           <vaadin-grid theme="row-dividers" column-reordering-allowed multi-sort items={{filteredProfiles}}>
                 <vaadin-grid-column width="9em" path="firstName"></vaadin-grid-column>
                 <vaadin-grid-column width="9em" path="lastName"></vaadin-grid-column>
                 <vaadin-grid-column width="9em" path="emailId"></vaadin-grid-column>
                 <vaadin-grid-column width="9em" path="salary"></vaadin-grid-column>
                 <vaadin-grid-column width="9em" path="caste"></vaadin-grid-column>
                 <vaadin-grid-column width="9em" path="action">
                 <template> 
                      <paper-button raised class="custom indigo bkg" id="[[]]" data-set$={{item}} on-click="_interested">Interested</paper-button>
                </template>
                </vaadin-grid-column>
         </vaadin-grid>
       
     </div>
   </template>
   <!--Profile List End -->

   <!--Interested List-->
   <template is="dom-if" if="{{interestedFlag}}">
      <div class="card-actions"  style="margin:20px;border:1px solid gray; background-color:ivory;padding:1%">
              <p>Interested Profiles:</p>
          <div></div>
        <vaadin-grid theme="row-dividers" column-reordering-allowed multi-sort items={{filteredInterested}}>
                      <vaadin-grid-column width="9em" path="interestedProfileName"></vaadin-grid-column>
                     
                      <vaadin-grid-column width="9em" path="accept">
                      <template> 

                                <paper-button raised class="custom indigo  bkg">Accept</paper-button>

                    </template>
                      </vaadin-grid-column>
 
                      <vaadin-grid-column width="9em" path="reject">
                      <template>
                            <paper-button toggles raised class="custom green bkg">Reject</paper-button>

                    </template>
                      </vaadin-grid-column>
                     <!--
                      <vaadin-grid-column width="9em" path="emailId"></vaadin-grid-column>
                      <vaadin-grid-column width="9em" path="salary"></vaadin-grid-column>
                      <vaadin-grid-column width="9em" path="caste"></vaadin-grid-column>-->
            </vaadin-grid>-->
          
        </div>
      </template>
   <!--Interested List End -->

   <!--Accepated List-->
   <template is="dom-if" if="{{acceptedFlag}}">
      <div class="card-actions"  style="margin:20px;border:1px solid gray; background-color:ivory;padding:1%">
              <p>Accepated Profiles:</p>
              <div></div>
              <vaadin-grid theme="row-dividers" column-reordering-allowed multi-sort items={{filteredAccepted}}>
                    <vaadin-grid-column width="9em" path="acceptedProfileName"></vaadin-grid-column>
                   <!-- <vaadin-grid-column width="9em" path="lastName"></vaadin-grid-column>
                    <vaadin-grid-column width="9em" path="emailId"></vaadin-grid-column>
                    <vaadin-grid-column width="9em" path="salary"></vaadin-grid-column>
                    <vaadin-grid-column width="9em" path="caste"></vaadin-grid-column>-->
            </vaadin-grid>
          
        </div>
      </template>
   <!--Accepated List End -->

   <!--Rejected List-->
   <template is="dom-if" if="{{rejectedFlag}}">
      <div class="card-actions"  style="margin:20px;border:1px solid gray; background-color:ivory;padding:1%">
              <p>Rejected:</p>
              <vaadin-grid theme="row-dividers" column-reordering-allowed multi-sort items={{filteredRejected}}>
                      <vaadin-grid-column width="9em" path="rejectedProfileName"></vaadin-grid-column>
                      <vaadin-grid-column width="9em" path="profileId"></vaadin-grid-column>
                      
            </vaadin-grid>
          
        </div>
      </template>
   <!--Rejected List End -->
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
      showSelectedGroupProductlist:{
        type:Boolean,
        value:false
      },
      createdAccountDetailsDialog:{
        type:Object, 
        value:{}
      },
      allProdu:{
        type:Array, 
        value:[]
      },
      baseUrl:{
        type:String,
        value: "http://10.117.189.210:8090/app"
      },
      triggerId:{
        type:String,
        value:""
      },
      collapseId:{
        type:String,
        value:"colid"
      },//SavingsCount,MortgageCount, MortgageCount
      SavingsCount:{
        type:Number,
        value:0
      },
      MortgageCount:{
        type:Number,
        value:0
      },
      PaymentCount:{
        type:Number,
        value:0
      },
   
      productMorgageList:{
        type:Array,
        value:[]
      },
      productPaymentList:{
        type:Array,
        value:[]
      },
      productSavingList:{
        type:Array,
        value:[]
      },
      profileListFlag:{
        type:Boolean,
        value:false
      },
      products:{
        type:Array,
        value:[]
      },
      selectedProductDetails:{
        type:Object,
        value:{}
      },
      productUniqId:{
        type:Number,
        value:0
      },
      profileListFlag:{
        type:Boolean,
        value:false,
      },
      interestedFlag:{
        type:Boolean,
        value:false,
      },
      acceptedFlag:{
        type:Boolean,
        value:false,
      },
      rejectedFlag:{
        type:Boolean,
        value:false,
      },
      filteredProfiles:{
        type:Array,
        value:[]
      },
      filteredInterested:{
        type:Array,
        value:[]
      },
      filteredRejected:{
        type:Array,
        value:[]

      }
     
     //////profileListFlag,interestedFlag,acceptedFlag,rejectedFlag 
    }
  }
  constructor() {
    super();
    
  }
  connectedCallback(){
        super.connectedCallback();
        this._getProfile();
       // this._getAllProductGroup();
        //this._getupdateOverview();

  }
  _interested(event){//interestedAjax,_interestedAjax/ interestSendAjax,_interestSendHandler
    //{profileId, profileName, actionProfileId, actionProfileName, action (Interest,accept,reject)
    console.log('_interested',  JSON.parse(event.target.dataset.set));
    let actionProfileData= JSON.parse(event.target.dataset.set)

    const jsonBody = { 
      profileId:  localStorage.loggedInId,
      profileName:localStorage.profileName,
      actionProfileId:actionProfileData.profileId,
      actionProfileName:actionProfileData.firstName,
      action:"Interest"

  }
    let ajaxRef = this.$.interestSendAjax;
    ajaxRef.method = "put"
    ajaxRef.body = jsonBody;
    ajaxRef.url = `${this.baseUrl}/updateInterest`,
    ajaxRef.contentType = "application/json"
    ajaxRef.generateRequest();
  }
 
  _interestSendHandler(event){
    const response = event.detail.response;
    if(response){
      alert("Congratulation! Your Interest has been successfully sent. ");
      
    }else{
      alert("Sorry, Your Interest could not happed");
    }
  }

  _switchBetweenLoginAndCreate(event){//Savings,Payments,Mortgage
    console.log('_switchBetweenLoginAndCreate', event.target.dataset.item$);
    let type=event.target.dataset.item$
   // this.showSelectedGroupProductlist=true;
    //this.prodctGroupName=type;        
    if(type=="profile"){
          this._getProfile();
          this.profileListFlag =true;
          this.interestedFlag =false;
          this.acceptedFlag =false;
          this.rejectedFlag=false;
          
    }else if(type=="interested"){
     this._getInterested()
            this.interestedFlag =true;
            this.acceptedFlag =false;
            this.rejectedFlag=false;
            this.profileListFlag =false;
    }else if(type=="accepted"){
      this._getAccepted();
      this.acceptedFlag =true;
      this.interestedFlag =false;
     
      this.rejectedFlag=false;
      this.profileListFlag =false;
    }else{
    //  alert("Comming Soon..");
      
      this._getRejected();
      this.acceptedFlag =false;
      this.interestedFlag =false;
      this.profileListFlag=false;
     
      this.rejectedFlag=true;
      
         
    }
    
  }
  
  
  
  _getProfile(){
    let profileId =  localStorage.loggedInId;
    let ajaxRef = this.$.profileAjax;
    ajaxRef.method = "get"
    ajaxRef.url = `${this.baseUrl}/getFilteredProfile/${profileId}`,
    ajaxRef.contentType = "application/json"
    ajaxRef.generateRequest();
  }
  _profileHandler(event){
    let data=event.detail.response;
    this.filteredProfiles = event.detail.response;
    if(data){
      this.profileListFlag =true;
      this.interestedFlag =false;
      this.acceptedFlag =false;
      this.rejectedFlag=false;
     
    }
    
  }
  
  _getAccepted(){
    let profileId =  localStorage.loggedInId;
    let ajaxRef = this.$.acceptedAjax;
    ajaxRef.method = "get"
    ajaxRef.url = `${this.baseUrl}/getAcceptedProfile/${profileId}`,
    ajaxRef.contentType = "application/json"
    ajaxRef.generateRequest();
  }
  _acceptedAjaxHanler(event){
    let data=event.detail.response;
    this.filteredAccepted = event.detail.response;
    if(data){
      this.acceptedFlag =true;
      this.profileListFlag =false;
      this.interestedFlag =false;
      this.rejectedFlag=false;
    }else{
      alert("No Data");
    }
    
  }
 
_getInterested(){
    let profileId =  localStorage.loggedInId;
    let ajaxRef = this.$.interestedAjax;
    ajaxRef.method = "get"
    ajaxRef.url = `${this.baseUrl}/getInterestedProfile/${profileId}`,
    ajaxRef.contentType = "application/json"
    ajaxRef.generateRequest();
  }
  _interestedHanler(event){
    let data=event.detail.response;
     this.filteredInterested = event.detail.response;
     if(data){
      this.acceptedFlag =false;
      this.profileListFlag =false;
      this.interestedFlag =true;
      this.rejectedFlag=false;
    }else{
      alert("No Data");
    }
    
  }

_getRejected(){
    this.profileListFlag =false;
    let profileId =  localStorage.loggedInId;
    let ajaxRef = this.$.rejectedAjax;
    ajaxRef.method = "get"
    ajaxRef.url = `${this.baseUrl}/getRejectedProfile/${profileId}`,
    ajaxRef.contentType = "application/json"
    ajaxRef.generateRequest();
  }
  _rejectedHandler(event){
    let data =event.detail.response;
     this.filteredRejected = event.detail.response;
     if(data){
      this.rejectedFlag=true;
      this.acceptedFlag =false;
      this.profileListFlag =false;
      this.interestedFlag =false;
     
    }else{
      alert("No Data");
    }
     
    
  }
  
  
    
  
  

  _errorHandler(){
    console.log("Error");
   // alert('error');
  }

  

  _handleError() {
   // alert('_handleError');
  }

}

// Register the x-custom element with the browser
customElements.define('dashboard-element', DashboardElement);