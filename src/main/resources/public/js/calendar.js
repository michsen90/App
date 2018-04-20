function Calendar = function(){
	
	this.toggleShow = function() {
        this.divCnt.classList.toggle('calendar-show');
    }

    this.show = function() {
        this.divCnt.classList.add('calendar-show');
    }

    this.hide = function() {
        this.divCnt.classList.remove('calendar-show');
    }
	
	this.init = function(){
		
		// ikonka kalendarza 
		this.input.classList.add('input-calendar');
		
		//kontener całego kalendarza
		this.divCnt = document.createElement('div');
		this.divCnt.classList.add('calendar');
		
		//przycisk prev, next
		this.divButtons = document.createElement('div');
		this.divButtons.className = "calendar-prev-next";
		
		//div miesiac i rok
		this.divDateText = document.createElement('div');
		this.divDateText.className = 'date-name';
		
		//wrzucamy do jednego headea
		this.divHeader = document.createElement('div');
		this.divHeader.classList.add('calendar-header');
		
		this.divHeader.appendChild(this.divButtons);
		this.divHeader.appendChild(this.divDateText);
		this.divCnt.appendChild(this.divHeader);
		
		//tabela kalendarza
		this.divTable = document.createElement('div');
		this.divTable.className = 'calendar-table-cnt';
	    this.divCnt.appendChild(this.divTable);
	    
	  //tworzymy wrapper dla input
        this.calendarWrapper = document.createElement('div');
        this.calendarWrapper.classList.add('input-calendar-cnt');
        this.input.parentElement.insertBefore(this.calendarWrapper, this.input);
        this.calendarWrapper.appendChild(this.input);
	    
        this.input.addEventListener('click', function() {
        	this.toggleShow();
        }.bind(this));
	};
	
	
}


